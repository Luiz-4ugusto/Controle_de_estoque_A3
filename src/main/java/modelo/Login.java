package modelo;

/**
 * Representa as credenciais de um usuário para autenticação no sistema.
 * Esta classe encapsula o nome de usuário (usuario) e a senha,
 * sendo utilizada para transportar os dados de login entre as camadas
 * da aplicação
 */

public class Login {

    private String usuario;
    private String senha;

    public Login() {}

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ModeloLogin [usuario=" + usuario + ", senha=" + senha + "]";
    }
}
