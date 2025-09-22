package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Fornecedor;
import classes.Produto;

public class FornecedorDAO {
    // criar tabela fornecedor
    // implementar aqui
    // implementar na tela

    public void salvar(Fornecedor fornecedor) {
        Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO fornecedor (documento, nome, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getDocumento());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getEndereco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar fornecedor: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public Fornecedor buscarPorDocumento(String documento) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM fornecedor WHERE documento = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, documento);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setDocumento(rs.getString("documento"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setEndereco(rs.getString("endereco"));
                
                return fornecedor;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar fornecedor: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public void atualizar(Fornecedor fornecedor) {
        Connection conexao = Conexao.getConexao();
        String sql = "UPDATE fornecedor SET documento = ?, nome = ?, telefone = ?, email = ?, endereco = ? WHERE documento = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getDocumento());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getEndereco());

            stmt.setString(6, fornecedor.getDocumento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar fornecedor: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void excluir(String documento) {
        Connection conexao = Conexao.getConexao();
        String sql = "DELETE FROM fornecedor WHERE documento = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, documento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir fornecedor: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
