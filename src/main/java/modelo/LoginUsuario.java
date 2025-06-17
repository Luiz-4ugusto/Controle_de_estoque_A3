package modelo;

/**
 * Representa as credenciais de um usuário para autenticação no sistema.
 * Esta classe encapsula o nome de usuário (username) e a senha,
 * sendo utilizada para transportar os dados de login entre as camadas
 * da aplicação
 */

public class LoginUsuario {

    private String username;
    private String senha;

    public LoginUsuario() {}

    public LoginUsuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ModeloLogin [username=" + username + ", senha=" + senha + "]";
    }
}
