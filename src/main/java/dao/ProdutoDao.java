/**
 * Classe responsável pelas operações de acesso a dados (DAO)
 * da entidade Produto no banco de dados.
 * @author luiz
 */
package dao;

import modelo.CadastrarProduto;
import modelo.CadastrarCategoria;
import java.sql.*;
import java.util.ArrayList;

public class CadastrarProdutoDao {

    private final ConexaoDAO conexaoDAO;

    /**
     * Construtor padrão que inicializa a conexão com o banco.
     */
    public CadastrarProdutoDao() {
        this.conexaoDAO = new ConexaoDAO();
    }

    /**
     * Retorna uma lista de todos os produtos cadastrados no banco.
     *
     * @return Lista de produtos com suas categorias associadas
     */
    public ArrayList<CadastrarProduto> getListaProdutos() {
        ArrayList<CadastrarProduto> lista = new ArrayList<>();

        String sql = "SELECT p.*, c.nome as categoria_nome, c.embalagem as categoria_embalagem, c.tamanho as categoria_tamanho "
                + "FROM tb_produto p JOIN tb_categoria c ON p.categoria_id = c.id  ORDER BY p.id ASC";

        try (Connection conn = conexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery(sql)) {

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
                String categoriaEmbalagem = res.getString("categoria_embalagem");
                String categoriaTamanho = res.getString("categoria_tamanho");

                CadastrarCategoria categoria = new CadastrarCategoria(categoriaId, categoriaNome, categoriaEmbalagem, categoriaTamanho);
                CadastrarProduto produto = new CadastrarProduto(id, nome, preco, quantidade, min, max, unidade, categoria);
                lista.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return lista;
    }

    /**
     * Insere um novo produto no banco de dados.
     *
     * @param p Produto a ser inserido
     * @return true se inserido com sucesso, false se houver erro
     */
    public boolean inserirProduto(CadastrarProduto p) {
        String sql = "INSERT INTO tb_produto(id, nome, preco, quantidade, min, max, unidade, categoria_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    /**
     * Remove um produto do banco pelo seu ID.
     *
     * @param id ID do produto
     * @return true se removido com sucesso, false se houver erro
     */
    public boolean removerProduto(int id) {
        String sql = "DELETE FROM tb_produto WHERE id = " + id;

        try (Connection conn = conexaoDAO.getConexao(); Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Atualiza os dados de um produto no banco.
     *
     * @param p Produto com dados atualizados
     * @return true se atualizado com sucesso, false se houver erro
     */
    public boolean atualizarProduto(CadastrarProduto p) {
        String sql = "UPDATE tb_produto SET nome=?, preco=?, quantidade=?, min=?, max=?, unidade=?, categoria_id=? WHERE id=?";

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    /**
     * Retorna o maior ID de produto já cadastrado.
     *
     * @return maior ID encontrado na tabela
     */
    public int maiorID() {
        int maiorID = 0;

        try (Connection conn = conexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_produto")) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    /**
     * Busca um produto pelo ID.
     *
     * @param id ID do produto
     * @return Produto encontrado ou null
     */
    public CadastrarProduto buscarProduto(int id) {
        CadastrarProduto produto = null;

        String sql = "SELECT p.*, c.nome as categoria_nome, c.embalagem as categoria_embalagem, c.tamanho as categoria_tamanho "
                + "FROM tb_produto p JOIN tb_categoria c ON p.categoria_id = c.id WHERE p.id = ?";

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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
                    String categoriaEmbalagem = res.getString("categoria_embalagem");
                    String categoriaTamanho = res.getString("categoria_tamanho");

                    CadastrarCategoria categoria = new CadastrarCategoria(categoriaId, categoriaNome, categoriaEmbalagem, categoriaTamanho);
                    produto = new CadastrarProduto(id, nome, preco, quantidade, min, max, unidade, categoria);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return produto;
    }

    /**
     * Retorna uma lista com os nomes de todos os produtos cadastrados.
     *
     * @return Lista de nomes de produtos
     */
    public ArrayList<String> getNomesProdutos() {
        ArrayList<String> nomes = new ArrayList<>();

        try (Connection conn = conexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery("SELECT nome FROM tb_produto")) {

            while (res.next()) {
                nomes.add(res.getString("nome"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return nomes;
    }

    /**
     * Busca um produto no banco de dados pelo seu nome.
     *
     * @param nome Nome do produto a ser buscado
     * @return Objeto {@link CadastrarProduto} encontrado ou null se não existir
     */
    public CadastrarProduto buscarProdutoPorNome(String nome) {
        CadastrarProduto produto = null;

        String sql = "SELECT p.*, c.nome AS categoria_nome, c.embalagem AS categoria_embalagem, c.tamanho AS categoria_tamanho "
                + "FROM tb_produto p JOIN tb_categoria c ON p.categoria_id = c.id WHERE p.nome = ?";

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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
                    String categoriaEmbalagem = res.getString("categoria_embalagem");
                    String categoriaTamanho = res.getString("categoria_tamanho");

                    CadastrarCategoria categoria = new CadastrarCategoria(categoriaId, categoriaNome, categoriaEmbalagem, categoriaTamanho);
                    produto = new CadastrarProduto(id, nome, preco, quantidade, min, max, unidade, categoria);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return produto;
    }
    
  public ResultSet contarProdutosPorCategoria() throws SQLException {
        String sql = "SELECT c.nome AS categoria, COUNT(p.id) AS quantidade "
                + "FROM tb_produto p JOIN tb_categoria c ON p.categoria_id = c.id "
                + "GROUP BY c.id, c.nome";

        Connection conn = conexaoDAO.getConexao();
        return conn.prepareStatement(sql).executeQuery();
    }
  
    public ResultSet contarProdutosEstoqueMaximo() throws SQLException {
        String sql = "SELECT id as codigo, nome as produto, quantidade as estoque, max as estoque_max "
                + "FROM tb_produto tp "
                + "WHERE tp.quantidade >= tp.max "
                + "GROUP BY tp.id";

        Connection conn = conexaoDAO.getConexao();
        return conn.prepareStatement(sql).executeQuery();
    }
    
    public ResultSet contarProdutosEstoqueMinimo() throws SQLException {
        String sql = "SELECT id as codigo, nome as produto, quantidade as estoque, min as estoque_min "
                + "FROM tb_produto tp "
                + "WHERE tp.quantidade <= tp.min "
                + "GROUP BY tp.id";

        Connection conn = conexaoDAO.getConexao();
        return conn.prepareStatement(sql).executeQuery();
    }
    
}
