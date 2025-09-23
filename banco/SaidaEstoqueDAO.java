package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import classes.SaidaEstoque;
import classes.Sessao;
import classes.Usuario;

public class SaidaEstoqueDAO {

    public void confirmarSaida(SaidaEstoque saida) {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false); // inicia transação

            // Pega usuário logado da Sessao
            Usuario usuarioAtual = Sessao.getUsuarioLogado();
            if (usuarioAtual == null) {
                throw new RuntimeException("Nenhum usuário logado.");
            }

            // 0) Verifica estoque disponível antes de permitir saída
            int estoqueAtual = 0;
            String sqlCheck = "SELECT quantidade FROM produto WHERE codigo = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlCheck)) {
                stmt.setInt(1, saida.getCod_produto());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        estoqueAtual = rs.getInt("quantidade");
                    } else {
                        throw new RuntimeException("Produto não encontrado no estoque.");
                    }
                }
            }

            if (saida.getQuantidade() > estoqueAtual) {
                throw new RuntimeException("Quantidade solicitada (" + saida.getQuantidade() +
                                           ") é maior que o estoque disponível (" + estoqueAtual + ").");
            }

            // 1) Registrar a saída no histórico
            String sqlSaida = "INSERT INTO saida_estoque (data_saida, cod_produto, quantidade, tipo_saida, usuario_id) "
                            + "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlSaida, Statement.RETURN_GENERATED_KEYS)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate data = LocalDate.parse(saida.getDataSaida(), formatter);
                stmt.setDate(1, java.sql.Date.valueOf(data));

                stmt.setInt(2, saida.getCod_produto());
                stmt.setInt(3, saida.getQuantidade());
                stmt.setString(4, saida.getTipoSaida());
                stmt.setInt(5, usuarioAtual.getId()); // usuário logado

                stmt.executeUpdate();

                // Recupera o documento gerado
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        saida.setDocumento(rs.getInt(1));
                    }
                }
            }

            // 2) Atualizar a quantidade do produto (subtrai do estoque)
            String sqlUpdateProduto = "UPDATE produto SET quantidade = quantidade - ? WHERE codigo = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlUpdateProduto)) {
                stmt.setInt(1, saida.getQuantidade());
                stmt.setInt(2, saida.getCod_produto());
                stmt.executeUpdate();
            }

            conexao.commit(); // confirma transação
        } catch (SQLException e) {
            try {
                conexao.rollback(); // desfaz alterações se der erro
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao desfazer transação: " + ex.getMessage(), ex);
            }
            throw new RuntimeException("Erro ao confirmar saída de estoque: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
