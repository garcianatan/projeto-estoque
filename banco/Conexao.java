package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3303/testeEstoque";
    private static final String user = "root";
    private static final String password = "alunolab";

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL não encontrado!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco:" + e.getMessage(), e);
        }
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }


    // public static void main(String[] args) {
    //     try {
            

    //         String user = "";
    //         String password = "";

    //         Connection conn = DriverManager.getConnection(url, user, password);
    //         JOptionPane.showMessageDialog(null, "Conectado com sucesso");

    //         conn.close();
    //     } catch (Exception e) {
    //         JOptionPane.showMessageDialog(null, "erro: " + e);
    //     }
    // }
}
