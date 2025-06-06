package dao;

import modelo.CadastrarUsuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CadastrarUsuarioDAO {

    public Connection getConexao() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_controledeestoque";
            String url = "jdbc:mysql://" + server + ":3306/"
                    + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "070600@";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado ao banco de gerenciamento de estoque para cadastro!");
            } else {
                System.out.println("Status: Conexão NÃO ESTABELECIDA ao banco de gerenciamento de estoque para cadastro!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: O driver JDBC não foi encontrado.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Erro: Não foi possível conectar ao banco de dados.");
            System.out.println("Detalhes do erro: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean inserirUsuario(CadastrarUsuario usuario) {
        String sql = "INSERT INTO tb_usuarios (username, email, senha) VALUES (?, ?, ?)";
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = this.getConexao();
            if (con == null) {
                System.err.println("Conexão nula ao tentar inserir usuário.");
                return false;
            }
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após inserção: " + e.getMessage());
            }
        }
    }

    public CadastrarUsuario buscarUsername(String username) {
        String sql = "SELECT id_cadastro, username, email, senha FROM tb_usuarios WHERE username = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        CadastrarUsuario usuario = null;
        try {
            con = this.getConexao();
            if (con == null) {
                System.err.println("Conexão nula ao tentar buscar usuário.");
                return null;
            }
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new CadastrarUsuario();
                usuario.setId_cadastro(rs.getInt("id_cadastro"));
                usuario.setNome(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por username: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após busca: " + e.getMessage());
            }
        }
        return usuario;
    }

    //Busca a lista de e-mails no banco para validar se já existe
    public CadastrarUsuario buscarEmail(String email) {
        String sql = "SELECT id_cadastro, username, email, senha FROM tb_usuarios WHERE email = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        CadastrarUsuario usuario = null;
        try {
            con = this.getConexao();
            if (con == null) {
                System.err.println("Conexão nula ao tentar buscar usuário por email.");
                return null;
            }
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new CadastrarUsuario();
                usuario.setId_cadastro(rs.getInt("id_cadastro"));
                usuario.setNome(rs.getString("username"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por email: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após busca por email: " + e.getMessage());
            }
        }
        return usuario;
    }

    public ArrayList<String> getAllUsernames() {
        String sql = "SELECT username FROM tb_usuarios";
        ArrayList<String> usernames = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = this.getConexao();
            if (con == null) {
                System.err.println("Conexão nula ao tentar obter todos os usernames.");
                return usernames;
            }
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter todos os usernames: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos após obter usernames: " + e.getMessage());
            }
        }
        return usernames;
    }
}
