package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Produto;
import classes.Usuario;

public class ProdutoDAO {
    // criar campo qntd no banvo
    public void salvar(Produto produto) {
        Connection conexao = Conexao.getConexao();
        String sql = "INSERT INTO produto (codigo, nome, descricao, categoria, fornecedor, preco_custo, preco_venda, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDesc());
            stmt.setString(4, produto.getCategoria());
            stmt.setString(5, produto.getFornecedor());
            stmt.setDouble(6, produto.getPrecoCusto());
            stmt.setDouble(7, produto.getPrecoVenda());
            stmt.setInt(8, 0) ;
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar produto: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public Produto buscarPorCodigo(int codigo) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM produto WHERE codigo = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDesc(rs.getString("descricao"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setPrecoCusto(rs.getDouble("preco_custo"));
                produto.setPrecoVenda(rs.getDouble("preco_venda"));
                return produto;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public void atualizar(Produto produto) {
        Connection conexao = Conexao.getConexao();
        String sql = "UPDATE produto SET nome = ?, descricao = ?, categoria = ?, fornecedor = ?, preco_custo = ?, preco_venda = ? WHERE codigo = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDesc());
            stmt.setString(3, produto.getCategoria());
            stmt.setString(4, produto.getFornecedor());
            stmt.setDouble(5, produto.getPrecoCusto());
            stmt.setDouble(6, produto.getPrecoVenda());
            stmt.setInt(7, produto.getCodigo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void excluir(int codigo) {
        Connection conexao = Conexao.getConexao();
        String sql = "DELETE FROM produto WHERE codigo = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage(), e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

}
