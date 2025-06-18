package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario; // Importa a classe modelo LoginUsuario

public class LoginDAO {

    private final ConexaoDAO conexaoDAO; // Instância de ConexaoDAO

    public LoginDAO() {
        this.conexaoDAO = new ConexaoDAO(); // Inicializa a ConexaoDAO
    }

    /**
     * Valida as credenciais de login de um usuário.
     *
     * @param usuario O nome de usuário a ser validado.
     * @param senha A senha a ser validada.
     * @return true se o login for válido, false caso contrário.
     */
    public boolean validarLogin(String usuario, String senha) {
        // Seleciona apenas o usuario, pois é o suficiente para verificar se a combinação existe.
        String sql = "SELECT usuario FROM tb_usuarios WHERE usuario = ? AND senha = ?";
        boolean loginValido = false;

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
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
     * objeto LoginUsuario contendo apenas o usuario e a senha se o usuário for
     * encontrado.
     *
     * @param usuario O nome de usuário a ser buscado.
     * @return Um objeto LoginUsuario (usuario e senha) se encontrado, ou null
     * caso contrário.
     */
    public Usuario buscarUsuario(String busuario) {
        // Altera a query para selecionar apenas os campos que LoginUsuario pode armazenar
        String sql = "SELECT usuario, senha FROM tb_usuarios WHERE usuario = ?";
        Usuario usuario = null;

        try (Connection conn = conexaoDAO.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, busuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Instancia LoginUsuario com usuario e senha
                    usuario = new Usuario(rs.getString("usuario"), rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por usuario para login: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }
}
