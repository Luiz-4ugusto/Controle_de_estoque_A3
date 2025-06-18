/**
 * Classe responsável por estabelecer a conexão com o banco de dados MySQL.
 *
 * Banco de dados: db_controledeestoque
 * Usuário: root
 * Senha: 070600@
 * @author luiz
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    private final String URL = "jdbc:mysql://localhost:3306/db_controledeestoque";
    private final String USER = "root";
    private final String PASSWORD = "070600@";

    /**
     * Estabelece e retorna a conexão com o banco de dados.
     *
     * @return Objeto {@link Connection} se a conexão for bem-sucedida, ou
     * {@code null} em caso de falha
     */
    public Connection getConexao() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados!");
            e.printStackTrace();
        }
        return connection;
    }
}
