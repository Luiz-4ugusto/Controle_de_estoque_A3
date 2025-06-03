
package modelo;

/**
 *
 * @author luiz
 */
public class CadastrarCategoria {
    private int id;
    private String nome;
    private String embalagem;
    private String tamanho;

    public CadastrarCategoria() {
        this(0, "", "", "");
    }

    public CadastrarCategoria(int id, String nome, String embalagem, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.embalagem = embalagem;
        this.tamanho = tamanho;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return nome + " - " + embalagem + " - " + tamanho;
    }
}