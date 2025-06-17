/**
 * Classe responsável pelo acesso ao banco de dados para a entidade Categoria.
 * Contém métodos para inserir, listar, buscar, atualizar e remover categorias.
 * @author luiz
 */
package dao;

import modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CategoriaDAO {

    private final ConexaoDAO conexaoDAO;
    /**
     * Construtor padrão. Inicializa a conexão com o banco de dados.
     */
    public CategoriaDAO() {
        this.conexaoDAO = new ConexaoDAO();
    }
    /**
     * Retorna uma lista com todas as categorias cadastradas.
     * 
     * @return ArrayList de Categoria.
     */
    public ArrayList<Categoria> getLista() {
        ArrayList<Categoria> lista = new ArrayList<>();

        try (Connection conn = conexaoDAO.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_categoria  ORDER BY id ASC")) {

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String embalagem = res.getString("embalagem");
                String tamanho = res.getString("tamanho");

                Categoria objeto = new Categoria(id, nome, embalagem, tamanho);
                lista.add(objeto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return lista;
    }

   /**
     * Insere uma nova categoria no banco de dados.
     * 
     * @param c Objeto Categoria a ser inserido.
     * @return true se inserção for bem-sucedida, false caso contrário.
     */
    public boolean inserirCategoria(Categoria c) {
        String sql = "INSERT INTO tb_categoria(id, nome, embalagem, tamanho) VALUES(?,?,?,?)";

        try (Connection conn = conexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEmbalagem());
            stmt.setString(4, c.getTamanho());
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Remove uma categoria do banco de dados pelo ID.
     * 
     * @param id Identificador da categoria a ser removida.
     * @return true se a remoção for bem-sucedida, false caso contrário.
     */
    public boolean removerCategoria(int id) {
        try (Connection conn = conexaoDAO.getConexao();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DELETE FROM tb_categoria WHERE id = " + id);
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }


    /**
     * Atualiza uma categoria no banco de dados.
     * 
     * @param c Objeto Categoria com os dados atualizados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizarCategoria(Categoria c) {
        String sql = "UPDATE tb_categoria SET nome = ?, embalagem = ?, tamanho = ? WHERE id = ?";

        try (Connection conn = conexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmbalagem());
            stmt.setString(3, c.getTamanho());
            stmt.setInt(4, c.getId());

            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Retorna o maior ID existente na tabela de categorias.
     * 
     * @return int com o maior ID encontrado.
     */
    public int maiorID() {
        int maiorID = 0;
        try (Connection conn = conexaoDAO.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_categoria")) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    /**
     * Busca uma categoria no banco de dados pelo ID.
     * 
     * @param id Identificador da categoria.
     * @return Objeto Categoria encontrado ou null se não existir.
     */
    public Categoria buscarCategoria(int id) {
        Categoria categoria = null;
        String sql = "SELECT * FROM tb_categoria WHERE id = ?";

        try (Connection conn = conexaoDAO.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    categoria = new Categoria(
                        res.getInt("id"),
                        res.getString("nome"),
                        res.getString("embalagem"),
                        res.getString("tamanho")
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return categoria;
    }

    /**
     * Retorna uma lista com os nomes de todas as categorias cadastradas.
     * 
     * @return ArrayList de Strings com os nomes das categorias formatados.
     */
    public ArrayList<String> getNomesCategorias() {
        ArrayList<String> nomes = new ArrayList<>();
        try (Connection conn = conexaoDAO.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery("SELECT nome, embalagem, tamanho FROM tb_categoria")) {

            while (res.next()) {
                String nome = res.getString("nome");
                String embalagem = res.getString("embalagem");
                String tamanho = res.getString("tamanho");
                nomes.add(nome + " - " + embalagem + " - " + tamanho);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return nomes;
    }
}
