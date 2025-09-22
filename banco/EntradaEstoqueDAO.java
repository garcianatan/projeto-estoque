package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            String sqlEntrada = "INSERT INTO entrada_estoque (documento, data_entrada, fornecedor, cod_produto, quantidade, tipo_entrada, usuario_id) "
                              + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sqlEntrada)) {
                stmt.setString(1, entrada.getDocumento());
                stmt.setString(2, entrada.getDataEntrada());
                stmt.setString(3, entrada.getFornecedor());
                stmt.setInt(4, entrada.getCod_produto());
                stmt.setInt(5, entrada.getQuantidade());
                stmt.setString(6, entrada.getTipoEntrada());

                Usuario usuarioAtual = Sessao.getUsuarioLogado();
                if(usuarioAtual == null){
                    throw new RuntimeException("Nenhum usuário logado.");
                }
                stmt.setInt(7, usuarioAtual.getId());

                stmt.executeUpdate();
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
