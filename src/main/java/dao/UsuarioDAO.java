package dao;

// Importa a classe de modelo que representa um usuário no sistema.
import modelo.Usuario;

// Importações necessárias para trabalhar com banco de dados em Java (JDBC).
import java.sql.Connection;        // Interface para estabelecer uma conexão com o banco de dados.
import java.sql.PreparedStatement; // Usado para executar instruções SQL pré-compiladas (mais seguro contra SQL Injection).
import java.sql.ResultSet;         // Usado para armazenar os resultados de uma consulta SQL.
import java.sql.SQLException;      // Classe para lidar com exceções de banco de dados.
import java.sql.Statement;         // Usado para executar instruções SQL simples.
import java.util.ArrayList;        // Para trabalhar com listas de objetos.

/**
 * Classe de Objeto de Acesso a Dados (DAO) para a entidade CadastrarUsuario.
 * Responsável por todas as operações de persistência (CRUD) relacionadas aos
 * usuários no banco de dados. Esta classe abstrai a lógica de acesso ao banco
 * de dados da camada de negócio.
 */
public class UsuarioDAO {

    // Instância da classe ConexaoDAO para gerenciar a conexão com o banco de dados.
    private final ConexaoDAO conexaoDAO;

    /**
     * Construtor da classe CadastrarUsuarioDAO. Inicializa uma nova instância
     * de ConexaoDAO para garantir que a conexão com o banco de dados esteja
     * disponível para as operações.
     */
    public UsuarioDAO() {
        this.conexaoDAO = new ConexaoDAO();
    }

    /**
     * Recupera todos os usuários cadastrados no banco de dados.
     *
     * @return Uma {@code ArrayList} de objetos {@code Usuario},
     * contendo todos os usuários encontrados. Retorna uma lista vazia se nenhum
     * usuário for encontrado ou em caso de erro.
     */
    public ArrayList<Usuario> getLista() {
        // Inicializa uma lista vazia para armazenar os usuários.
        ArrayList<Usuario> lista = new ArrayList<>();
        // Define a query SQL para selecionar todos os dados da tabela de usuários.
        // O ORDER BY id ASC garante que os resultados venham ordenados pelo ID.
        String sql = "SELECT id_cadastro, usuario, email, senha FROM tb_usuarios ORDER BY id_cadastro ASC";

        // O 'try-with-resources' garante que Connection, Statement e ResultSet sejam fechados automaticamente.
        try (Connection conn = conexaoDAO.getConexao(); // Obtém a conexão com o banco de dados.
                 Statement stmt = conn.createStatement(); // Cria um objeto Statement para executar a query.
                 ResultSet res = stmt.executeQuery(sql)) {  // Executa a query e obtém os resultados.

            // Itera sobre cada linha (registro) retornada pelo ResultSet.
            while (res.next()) {
                // Mapeia os dados de cada coluna do ResultSet para variáveis Java.
                int id = res.getInt("id_cadastro");
                String usuario = res.getString("usuario");
                String email = res.getString("email");
                String senha = res.getString("senha"); // Nota: Em aplicações reais, senhas nunca devem ser lidas em texto puro.

                // Cria um novo objeto Usuario com os dados recuperados do banco.
                Usuario objeto = new Usuario(id, usuario, email, senha);
                // Adiciona o objeto à lista.
                lista.add(objeto);
            }
        } catch (SQLException ex) {
            // Em caso de erro SQL, imprime uma mensagem de erro e o stack trace para depuração.
            System.err.println("Erro ao obter lista de usuários: " + ex.getMessage());
            ex.printStackTrace();
        }
        // Retorna a lista de usuários.
        return lista;
    }

    /**
     * Insere um novo usuário no banco de dados.
     *
     * @param usuario O objeto {@code Usuario} contendo os dados do
     * novo usuário (nome de usuário, e-mail e senha).
     * @return {@code true} se o usuário foi inserido com sucesso (uma linha
     * afetada), {@code false} caso contrário (nenhuma linha afetada ou erro de
     * SQL).
     */
    public boolean inserirUsuario(Usuario usuario) {
        // Define a query SQL para inserir um novo registro.
        // O uso de '?' (placeholders) é uma prática segura para evitar SQL Injection.
        String sql = "INSERT INTO tb_usuarios (usuario, email, senha) VALUES (?, ?, ?)";

        // O 'try-with-resources' garante que Connection e PreparedStatement sejam fechados automaticamente.
        try (Connection con = conexaoDAO.getConexao(); // Obtém a conexão com o banco de dados.
                 PreparedStatement pst = con.prepareStatement(sql)) { // Prepara a instrução SQL.

            // Define os valores para os placeholders da query.
            pst.setString(1, usuario.getNome());  // Define o valor para o primeiro '?' (usuario).
            pst.setString(2, usuario.getEmail()); // Define o valor para o segundo '?' (email).
            pst.setString(3, usuario.getSenha()); // Define o valor para o terceiro '?' (senha).

            // Executa a atualização no banco de dados.
            // O retorno é o número de linhas afetadas.
            int rowsAffected = pst.executeUpdate();
            // Retorna verdadeiro se pelo menos uma linha foi inserida.
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Em caso de erro SQL durante a inserção, imprime uma mensagem de erro e o stack trace.
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            e.printStackTrace();
            // Retorna falso indicando que a inserção falhou.
            return false;
        }
    }

    /**
     * Busca um usuário no banco de dados usando o nome de usuário (usuario).
     *
     * @param usuarioBusca O nome de usuário a ser procurado no banco de dados.
     * @return Um objeto {@code Usuario} se um usuário com o nome de
     * usuário especificado for encontrado. Retorna {@code null} se nenhum
     * usuário for encontrado ou em caso de erro.
     */
    public Usuario buscarUsuario(String usuarioBusca) {
        // Define a query SQL para buscar um usuário pelo usuario.
        String sql = "SELECT id_cadastro, usuario, email, senha FROM tb_usuarios WHERE usuario = ?";
        Usuario usuario = null; // Inicializa o objeto usuário como nulo.

        // O 'try-with-resources' garante que Connection, PreparedStatement e ResultSet sejam fechados.
        try (Connection con = conexaoDAO.getConexao(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, usuarioBusca); // Define o usuario para o placeholder.
            try (ResultSet rs = pst.executeQuery()) { // Executa a query e obtém o resultado.
                if (rs.next()) { // Se encontrou um registro (usuario é geralmente único).
                    // Mapeia os dados do ResultSet para um objeto Usuario.
                    int id = rs.getInt("id_cadastro");
                    String foundUsuario = rs.getString("usuario");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    usuario = new Usuario(id, foundUsuario, email, senha);
                }
            }
        } catch (SQLException e) {
            // Em caso de erro SQL, imprime uma mensagem de erro e o stack trace.
            System.err.println("Erro ao buscar usuário por usuario: " + e.getMessage());
            e.printStackTrace();
        }
        // Retorna o usuário encontrado ou null.
        return usuario;
    }

    /**
     * Busca um usuário no banco de dados usando o endereço de e-mail.
     *
     * @param emailBusca O endereço de e-mail a ser procurado no banco de dados.
     * @return Um objeto {@code Usuario} se um usuário com o e-mail
     * especificado for encontrado. Retorna {@code null} se nenhum usuário for
     * encontrado ou em caso de erro.
     */
    public Usuario buscarEmail(String emailBusca) {
        // Define a query SQL para buscar um usuário pelo email.
        String sql = "SELECT id_cadastro, usuario, email, senha FROM tb_usuarios WHERE email = ?";
        Usuario usuario = null; // Inicializa o objeto usuário como nulo.

        // O 'try-with-resources' garante que Connection, PreparedStatement e ResultSet sejam fechados.
        try (Connection con = conexaoDAO.getConexao(); PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, emailBusca); // Define o email para o placeholder.
            try (ResultSet rs = pst.executeQuery()) { // Executa a query e obtém o resultado.
                if (rs.next()) { // Se encontrou um registro (email deve ser único).
                    // Mapeia os dados do ResultSet para um objeto Usuario.
                    int id = rs.getInt("id_cadastro");
                    String usuarioNome = rs.getString("usuario");
                    String foundEmail = rs.getString("email");
                    String senha = rs.getString("senha");
                    usuario = new Usuario(id, usuarioNome, foundEmail, senha);
                }
            }
        } catch (SQLException e) {
            // Em caso de erro SQL, imprime uma mensagem de erro e o stack trace.
            System.err.println("Erro ao buscar usuário por email: " + e.getMessage());
            e.printStackTrace();
        }
        // Retorna o usuário encontrado ou null.
        return usuario;
    }

    /**
     * Retorna uma lista contendo apenas os nomes de usuário (usuario) de
     * todos os usuários cadastrados no banco de dados.
     *
     * @return Uma {@code ArrayList} de {@code String} contendo todos os nomes
     * de usuário. Retorna uma lista vazia se nenhum usuario for encontrado ou
     * em caso de erro.
     */
    public ArrayList<String> getAllusuarios() {
        // Define a query SQL para selecionar apenas a coluna 'usuario'.
        String sql = "SELECT usuario FROM tb_usuarios";
        ArrayList<String> usuarios = new ArrayList<>(); // Inicializa uma lista para os usuarios.

        // O 'try-with-resources' garante que Connection, Statement e ResultSet sejam fechados.
        try (Connection con = conexaoDAO.getConexao(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) { // Itera sobre cada resultado.
                usuarios.add(rs.getString("usuario")); // Adiciona o usuario à lista.
            }
        } catch (SQLException e) {
            // Em caso de erro SQL, imprime uma mensagem de erro e o stack trace.
            System.err.println("Erro ao obter todos os usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        // Retorna a lista de usuarios.
        return usuarios;
    }
}
