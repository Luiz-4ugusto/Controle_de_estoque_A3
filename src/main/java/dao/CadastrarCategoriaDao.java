
package dao;

import modelo.CadastrarCategoria;
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
public class CadastrarCategoriaDao {

    // Retorna lista de categorias
    public ArrayList<CadastrarCategoria> getLista() {
        ArrayList<CadastrarCategoria> lista = new ArrayList<>();

        try (Connection conn = ConexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery("SELECT * FROM tb_categoria")) {

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String embalagem = res.getString("embalagem");
                String tamanho = res.getString("tamanho");

                CadastrarCategoria objeto = new CadastrarCategoria(id, nome, embalagem, tamanho);
                lista.add(objeto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return lista;
    }

    // inserir nova categoria
    public boolean inserirCategoria(CadastrarCategoria c) {
        String sql = "INSERT INTO tb_categoria(id, nome, embalagem, tamanho) VALUES(?,?,?,?)";

        try (Connection conn = ConexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    // Deleta categoria 
    public boolean removerCategoria(int id) {
        try (Connection conn = ConexaoDAO.getConexao(); Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DELETE FROM tb_categoria WHERE id = " + id);
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    // atualizzar uma categoria
    public boolean atualizarCategoria(CadastrarCategoria c) {
        String sql = "UPDATE tb_categoria SET nome = ?, embalagem = ?, tamanho = ? WHERE id = ?";

        try (Connection conn = ConexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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

    // pegar maior ID
    public int maiorID() {
        int maiorID = 0;
        try (Connection conn = ConexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_categoria")) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    // Busca categoria
    public CadastrarCategoria buscarCategoria(int id) {
        CadastrarCategoria categoria = null;
        String sql = "SELECT * FROM tb_categoria WHERE id = ?";

        try (Connection conn = ConexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    categoria = new CadastrarCategoria(res.getInt("id"),res.getString("nome"),res.getString("embalagem"),res.getString("tamanho")
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return categoria;
    }

    // lista de nomes de categorias
    public ArrayList<String> getNomesCategorias() {
        ArrayList<String> nomes = new ArrayList<>();
        try (Connection conn = ConexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery("SELECT nome, embalagem, tamanho FROM tb_categoria")) {

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
