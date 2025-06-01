/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.CadastrarProduto;
import modelo.Cadastrar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author luiz
 */
public class ProdutoCadastrarDao {
    // Retorna lista de produtos
    public ArrayList<CadastrarProduto> getListaProdutos() {
        ArrayList<CadastrarProduto> lista = new ArrayList<>();
        
        String sql = "SELECT p.*, c.nome as categoria_nome FROM tb_produto p " +
                     "JOIN tb_categoria c ON p.categoria_id = c.id";
        
        try (Connection conn = ConexaoDAO.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {
            
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                double preco = res.getDouble("preco");
                int quantidade = res.getInt("quantidade");
                int min = res.getInt("min");
                int max = res.getInt("max");
                String unidade = res.getString("unidade");
                int categoriaId = res.getInt("categoria_id");
                String categoriaNome = res.getString("categoria_nome");
                
                Cadastrar categoria = new Cadastrar(categoriaId, categoriaNome);
                CadastrarProduto produto = new CadastrarProduto(id, nome, preco, quantidade, min, max, unidade, categoria);
                lista.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return lista;
    }

    // Cadastra novo produto
    public boolean inserirProduto(CadastrarProduto p) {
        String sql = "INSERT INTO tb_produto(id, nome, preco, quantidade, min, max, unidade, categoria_id) " +
                     "VALUES(?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getQuantidade());
            stmt.setInt(5, p.getMin());
            stmt.setInt(6, p.getMax());
            stmt.setString(7, p.getUnidade());
            stmt.setInt(8, p.getCategoria().getId());
            
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    // Deletar produto 
    public boolean removerProduto(int id) {
        try (Connection conn = ConexaoDAO.getConexao();
             Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate("DELETE FROM tb_produto WHERE id = " + id);
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    // Edita produto
    public boolean atualizarProduto(CadastrarProduto p) {
        String sql = "UPDATE tb_produto SET nome=?, preco=?, quantidade=?, min=?, max=?, unidade=?, categoria_id=? " +
                     "WHERE id=?";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, p.getMin());
            stmt.setInt(5, p.getMax());
            stmt.setString(6, p.getUnidade());
            stmt.setInt(7, p.getCategoria().getId());
            stmt.setInt(8, p.getId());
            
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    // Retorna maior ID
    public int maiorID() {
        int maiorID = 0;
        try (Connection conn = ConexaoDAO.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_produto")) {
            
            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }
    
    // Busca produto 
    public CadastrarProduto buscarProduto(int id) {
        CadastrarProduto produto = null;
        String sql = "SELECT p.*, c.nome as categoria_nome FROM tb_produto p " +
                     "JOIN tb_categoria c ON p.categoria_id = c.id " +
                     "WHERE p.id = ?";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    String nome = res.getString("nome");
                    double preco = res.getDouble("preco");
                    int quantidade = res.getInt("quantidade");
                    int min = res.getInt("min");
                    int max = res.getInt("max");
                    String unidade = res.getString("unidade");
                    int categoriaId = res.getInt("categoria_id");
                    String categoriaNome = res.getString("categoria_nome");
                    
                    Cadastrar categoria = new Cadastrar(categoriaId, categoriaNome);
                    produto = new CadastrarProduto(id, nome, preco, quantidade, min, max, unidade, categoria);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return produto;
    }
    
    // Retorna lista de de produtos
    public ArrayList<String> getNomesProdutos() {
        ArrayList<String> nomes = new ArrayList<>();
        try (Connection conn = ConexaoDAO.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT nome FROM tb_produto")) {
            
            while (res.next()) {
                nomes.add(res.getString("nome"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return nomes;
    }
    
    // Busca produto por nome
    public CadastrarProduto buscarProdutoPorNome(String nome) {
        CadastrarProduto produto = null;
        String sql = "SELECT p.*, c.nome as categoria_nome FROM tb_produto p " +
                     "JOIN tb_categoria c ON p.categoria_id = c.id " +
                     "WHERE p.nome = ?";
        
        try (Connection conn = ConexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    int id = res.getInt("id");
                    double preco = res.getDouble("preco");
                    int quantidade = res.getInt("quantidade");
                    int min = res.getInt("min");
                    int max = res.getInt("max");
                    String unidade = res.getString("unidade");
                    int categoriaId = res.getInt("categoria_id");
                    String categoriaNome = res.getString("categoria_nome");
                    
                    Cadastrar categoria = new Cadastrar(categoriaId, categoriaNome);
                    produto = new CadastrarProduto(id, nome, preco, quantidade, min, max, unidade, categoria);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return produto;
    }
}
