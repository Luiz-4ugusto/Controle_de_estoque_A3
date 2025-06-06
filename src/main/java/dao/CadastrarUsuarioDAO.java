package dao;

import modelo.CadastrarUsuario; // Importa a classe modelo CadastrarUsuario

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CadastrarUsuarioDAO {

    private final ConexaoDAO conexaoDAO;

    /**
     * Construtor padrão. Inicializa a conexão com o banco de dados.
     */
    public CadastrarUsuarioDAO() {
        this.conexaoDAO = new ConexaoDAO();
    }

    /**
     * Retorna uma lista com todos os usuários cadastrados.
     *
     * @return ArrayList de CadastrarUsuario.
     */
    public ArrayList<CadastrarUsuario> getLista() {
        ArrayList<CadastrarUsuario> lista = new ArrayList<>();
        // Query para selecionar todos os campos que o CadastrarUsuario possui
        String sql = "SELECT id, username, email, senha FROM tb_usuarios ORDER BY id ASC";

        try (Connection conn = conexaoDAO.getConexao(); Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery(sql)) {

            while (res.next()) {
                // Mapeia os dados do ResultSet para um objeto CadastrarUsuario
                int id = res.getInt("id");
                String username = res.getString("username");
                String email = res.getString("email");
                String senha = res.getString("senha");

                // Utiliza o construtor completo de CadastrarUsuario
                CadastrarUsuario objeto = new CadastrarUsuario(id, username, email, senha);
                lista.add(objeto);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao obter lista de usuários: " + ex.getMessage());
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Insere um novo usuário no banco de dados.
     *
     * @param usuario Objeto CadastrarUsuario com os dados a serem inseridos.
     * @return true se o usuário foi inserido com sucesso, false caso contrário.
     */
    public boolean inserirUsuario(CadastrarUsuario usuario) {
        String sql = "INSERT INTO tb_usuarios (username, email, senha) VALUES (?, ?, ?)";

        try (Connection con = conexaoDAO.getConexao(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Retorna true se a inserção foi bem-sucedida
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Busca um usuário no banco de dados pelo nome de usuário.
     *
     * @param username O nome de usuário a ser buscado.
     * @return Um objeto CadastrarUsuario se encontrado, ou null caso contrário.
     */
    public CadastrarUsuario buscarUsername(String username) {
        // Query para selecionar todos os campos do usuário
        String sql = "SELECT id, username, email, senha FROM tb_usuarios WHERE username = ?";
        CadastrarUsuario usuario = null;

        try (Connection con = conexaoDAO.getConexao(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Mapeia todos os campos para o objeto CadastrarUsuario
                    int id = rs.getInt("id");
                    String foundUsername = rs.getString("username");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    usuario = new CadastrarUsuario(id, foundUsername, email, senha);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por username: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    /**
     * Busca um usuário no banco de dados pelo email.
     *
     * @param email O email a ser buscado.
     * @return Um objeto CadastrarUsuario se encontrado, ou null caso contrário.
     */
    public CadastrarUsuario buscarEmail(String email) {
        // Query para selecionar todos os campos do usuário
        String sql = "SELECT id, username, email, senha FROM tb_usuarios WHERE email = ?";
        CadastrarUsuario usuario = null;

        try (Connection con = conexaoDAO.getConexao(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, email);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Mapeia todos os campos para o objeto CadastrarUsuario
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String foundEmail = rs.getString("email");
                    String senha = rs.getString("senha");
                    usuario = new CadastrarUsuario(id, username, foundEmail, senha);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por email: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    /**
     * Retorna uma lista de todos os nomes de usuário cadastrados.
     *
     * @return ArrayList de String contendo os usernames.
     */
    public ArrayList<String> getAllUsernames() {
        String sql = "SELECT username FROM tb_usuarios"; // Query específica para usernames
        ArrayList<String> usernames = new ArrayList<>();

        try (Connection con = conexaoDAO.getConexao(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter todos os usernames: " + e.getMessage());
            e.printStackTrace();
        }
        return usernames;
    }
}
