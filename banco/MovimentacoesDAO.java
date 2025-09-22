package banco;
 
import java.sql.*;
import javax.swing.table.DefaultTableModel;
 
public class MovimentacoesDAO {
 
    public static DefaultTableModel carregarMovimentacoes() {
        String[] colunas = {"Data", "Tipo", "Nº do Documento", "Produto", "Quantidade", "Usuário Responsável"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
 
        String sql = "";
 
        try (Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
 
            while(rs.next()) {
                modelo.addRow(new Object[]{
 
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return modelo;
 
    }
 
    public static void buscarPorNum_Documento(DefaultTableModel modelo, int num_documento) {
        modelo.setRowCount(0);
 
        String sql = "";
 
        try(Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setInt(1, num_documento);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    modelo.addRow(new Object[]{
 
                    });
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}