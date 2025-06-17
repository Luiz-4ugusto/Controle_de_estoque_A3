package modelo;

public class CadastrarUsuario {

    private int id_cadastro;
    private String nome;
    private String email;
    private String senha;

    public CadastrarUsuario() {
        this(0, "", "", "");
    }

    public CadastrarUsuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public CadastrarUsuario(int id_cadastro, String nome, String email, String senha) {
        this.id_cadastro = id_cadastro;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters para id_cadastro
    public int getId_cadastro() {
        return id_cadastro;
    }

    public void setId_cadastro(int id_cadastro) {
        this.id_cadastro = id_cadastro;
    }

    // Getters e Setters para nome (username)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getters e Setters para email (NOVO)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters e Setters para senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ID=" + id_cadastro + ", username=" + nome + ", email=" + email + ", senha=<oculto>";
    }
}
