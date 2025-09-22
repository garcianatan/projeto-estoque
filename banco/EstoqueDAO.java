package banco;
 
import java.sql.*;
import javax.swing.table.DefaultTableModel;
 
public class EstoqueDAO {
 
    public static DefaultTableModel carregarEstoque() {
        String[] colunas = {"Código", "Produto", "Categoria", "Estoque Atual"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
   
        String sql = "SELECT codigo, nome, categoria, quantidade FROM produto";
   
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
   
            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getInt("quantidade")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
        return modelo;
    }
   
 
    // 🔹 Novo método para buscar por código
    public static void buscarPorCodigo(DefaultTableModel modelo, int codigo) {
        modelo.setRowCount(0); // limpa tabela
 
        String sql = "SELECT codigo, nome, categoria, quantidade FROM produto WHERE codigo = ?";
 
        try (Connection con = Conexao.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setInt(1, codigo); // substitui o ?
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    modelo.addRow(new Object[]{
                            rs.getInt("codigo"),
                            rs.getString("nome"),
                            rs.getString("categoria"),
                            rs.getInt("quantidade")
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}