package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LoginUsuario; // Importa a classe modelo LoginUsuario

public class LoginDAO {

    private final ConexaoDAO conexaoDAO; // Instância de ConexaoDAO

    public LoginDAO() {
        this.conexaoDAO = new ConexaoDAO(); // Inicializa a ConexaoDAO
    }

    /**
     * Valida as credenciais de login de um usuário.
     *
     * @param username O nome de usuário a ser validado.
     * @param senha A senha a ser validada.
     * @return true se o login for válido, false caso contrário.
     */
    public boolean validarLogin(String username, String senha) {
        // Seleciona apenas o username, pois é o suficiente para verificar se a combinação existe.
        String sql = "SELECT username FROM tb_usuarios WHERE username = ? AND senha = ?";
        boolean loginValido = false;

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                // Se rs.next() retornar true, significa que uma correspondência foi encontrada.
                if (rs.next()) {
                    loginValido = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao validar login: " + e.getMessage());
            e.printStackTrace();
        }
        return loginValido;
    }

    /**
     * Busca um usuário pelo nome de usuário para fins de login. Retorna um
     * objeto LoginUsuario contendo apenas o username e a senha se o usuário for
     * encontrado.
     *
     * @param username O nome de usuário a ser buscado.
     * @return Um objeto LoginUsuario (username e senha) se encontrado, ou null
     * caso contrário.
     */
    public LoginUsuario buscarUsername(String username) {
        // Altera a query para selecionar apenas os campos que LoginUsuario pode armazenar
        String sql = "SELECT username, senha FROM tb_usuarios WHERE username = ?";
        LoginUsuario usuario = null;

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Instancia LoginUsuario com username e senha
                    usuario = new LoginUsuario(rs.getString("username"), rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por username para login: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }
}
