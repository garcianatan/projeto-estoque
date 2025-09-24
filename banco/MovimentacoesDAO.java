package banco;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MovimentacoesDAO {

    public static DefaultTableModel carregarMovimentacoes() {
        // Define colunas
        String[] colunas = {"Data", "Movimentação", "Tipo", "Nº do Documento", "Produto", "Quantidade", "Usuário Responsável"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        // SQL UNION das duas tabelas
        String sql =
            "SELECT e.data_entrada AS data, 'Entrada' AS movimentacao, e.tipo_entrada AS tipo, e.documento, p.nome AS produto, e.quantidade, u.nome AS usuario " +
            "FROM entrada_estoque e " +
            "JOIN produto p ON e.cod_produto = p.codigo " +
            "JOIN usuario u ON e.usuario_id = u.id " +
            "UNION ALL " +
            "SELECT s.data_saida AS data, 'Saída' AS movimentacao, s.tipo_saida AS tipo, s.documento, p.nome AS produto, s.quantidade, u.nome AS usuario " +
            "FROM saida_estoque s " +
            "JOIN produto p ON s.cod_produto = p.codigo " +
            "JOIN usuario u ON s.usuario_id = u.id " +
            "ORDER BY data DESC";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getDate("data"),
                    rs.getString("movimentacao"),  // Entrada ou Saída
                    rs.getString("tipo"),          // Venda, Devolução, Compra, etc
                    rs.getInt("documento"),
                    rs.getString("produto"),
                    rs.getInt("quantidade"),
                    rs.getString("usuario")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

    // 🔎 Método para buscar por Nº do Documento
    public static void buscarPorDocumento(DefaultTableModel modelo, int doc) {
        modelo.setRowCount(0); // limpa tabela

        String sql =
            "SELECT e.data_entrada AS data, 'Entrada' AS movimentacao, e.tipo_entrada AS tipo, e.documento, p.nome AS produto, e.quantidade, u.nome AS usuario " +
            "FROM entrada_estoque e " +
            "JOIN produto p ON e.cod_produto = p.codigo " +
            "JOIN usuario u ON e.usuario_id = u.id " +
            "WHERE e.documento = ? " +
            "UNION ALL " +
            "SELECT s.data_saida AS data, 'Saída' AS movimentacao, s.tipo_saida AS tipo, s.documento, p.nome AS produto, s.quantidade, u.nome AS usuario " +
            "FROM saida_estoque s " +
            "JOIN produto p ON s.cod_produto = p.codigo " +
            "JOIN usuario u ON s.usuario_id = u.id " +
            "WHERE s.documento = ? " +
            "ORDER BY data DESC";

        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doc);
            ps.setInt(2, doc);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getDate("data"),
                        rs.getString("movimentacao"),
                        rs.getString("tipo"),
                        rs.getInt("documento"),
                        rs.getString("produto"),
                        rs.getInt("quantidade"),
                        rs.getString("usuario")
                    });
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
