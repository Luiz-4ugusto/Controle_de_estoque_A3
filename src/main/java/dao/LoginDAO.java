package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LoginUsuario;

public class LoginDAO {

    public Connection getConexao() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_controledeestoque";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "070600@";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado ao banco de dados!");
            } else {
                System.out.println("Status: NÃO CONECTADO ao banco de dados!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver JDBC não foi encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public boolean validarLogin(String username, String senha) {
        String sql = "SELECT * FROM tb_usuarios WHERE username = ? AND senha = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean loginValido = false;

        try {
            conn = this.getConexao();
            if (conn != null) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, senha);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    loginValido = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao validar login: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return loginValido;
    }

    public LoginUsuario buscarUsername(String username) {
        String sql = "SELECT id_cadastro, username, email, senha FROM tb_usuarios WHERE username = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        LoginUsuario usuario = null;

        try {
            conn = this.getConexao();
            if (conn != null) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    usuario = new LoginUsuario(rs.getString("senha"), rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return usuario;
    }

    public boolean inserirUsername(LoginUsuario usuario) {
        String sql = "INSERT INTO tb_usuarios (username, senha) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean inserido = false;

        try {
            conn = this.getConexao();
            if (conn != null) {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getUsername());
                stmt.setString(2, usuario.getSenha());

                int linhasAfetadas = stmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    inserido = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return inserido;
    }
}
