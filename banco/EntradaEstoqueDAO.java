package banco;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import classes.EntradaEstoque;
// import classes.Usuario;
import classes.Sessao;
import classes.Usuario;

public class EntradaEstoqueDAO {

    public void confirmarEntrada(EntradaEstoque entrada) {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false); // inicia transação

            // 1) Registrar a entrada no histórico
            String sqlEntrada = "INSERT INTO entrada_estoque (data_entrada, fornecedor, cod_produto, quantidade, tipo_entrada, usuario_id) "
                              + "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlEntrada, Statement.RETURN_GENERATED_KEYS)) {
                
                stmt.setDate(1, Date.valueOf(entrada.getDataEntrada()));
                stmt.setString(2, entrada.getFornecedor());
                stmt.setInt(3, entrada.getCod_produto());
                stmt.setInt(4, entrada.getQuantidade());
                stmt.setString(5, entrada.getTipoEntrada());

                Usuario usuarioAtual = Sessao.getUsuarioLogado();
                if(usuarioAtual == null){
                    throw new RuntimeException("Nenhum usuário logado.");
                }
                stmt.setInt(6, usuarioAtual.getId());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int docGerado = rs.getInt(1);
                    entrada.setDocumento(docGerado); // guarda o número gerado
                }

            }

            // 2) Atualizar a quantidade do produto
            String sqlUpdateProduto = "UPDATE produto SET quantidade = quantidade + ? WHERE codigo = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlUpdateProduto)) {
                stmt.setInt(1, entrada.getQuantidade());
                stmt.setInt(2, entrada.getCod_produto());
                stmt.executeUpdate();
            }

            conexao.commit(); // confirma transação
        } catch (SQLException e) {
            try {
                conexao.rollback(); // desfaz alterações se der erro
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao desfazer transação: " + ex.getMessage(), ex);
            }
            throw new RuntimeException("Erro ao confirmar entrada de estoque: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
