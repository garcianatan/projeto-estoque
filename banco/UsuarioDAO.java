package banco;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void salvar(Usuario usuario) {
        Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO usuario (id, nome, cargo, email, senha) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getCargo());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public Usuario buscarPorEmail(String email) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM usuario WHERE email = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    // implementar login
    public Usuario buscarLogin(String email, String senha) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                
                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public void atualizar(Usuario usuario) {
        Connection conexao = Conexao.getConexao();
        String sql = "UPDATE usuario SET nome = ?, cargo = ?, email = ?, senha = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCargo());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void excluir(int id) {
        Connection conexao = Conexao.getConexao();
        String sql = "DELETE FROM usuario WHERE id = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}
