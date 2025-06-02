package modelo;

public class ModeloLogin {

    private String username;
    private String senha;

    public ModeloLogin() {}

    public ModeloLogin(String username, String senha) {
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