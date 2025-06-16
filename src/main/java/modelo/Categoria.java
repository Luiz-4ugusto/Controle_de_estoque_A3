
package modelo;

/**
 * Classe responsável por representar uma categoria de produto.
 * Contém id, nome, tipo de embalagem e tamanho.
 * 
 * Esta classe é utilizada para manipulação de dados de categorias no sistema de controle de estoque.
 * @author luiz
 */
public class CadastrarCategoria {
    private int id;
    private String nome;
    private String embalagem;
    private String tamanho;
    /**
     * Construtor padrão que inicializa os campos com valores vazios ou zero.
     */
    public CadastrarCategoria() {
        this(0, "", "", "");
    }
    /**
     * Construtor completo que permite inicializar todos os campos da categoria.
     * 
     * @param id         ID da categoria
     * @param nome       Nome da categoria
     * @param embalagem  Tipo de embalagem da categoria
     * @param tamanho    Tamanho da embalagem
     */
    public CadastrarCategoria(int id, String nome, String embalagem, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.embalagem = embalagem;
        this.tamanho = tamanho;
    }

    // Getters e Setters
    // Os métodos abaixo permitem acessar e modificar os atributos da categoria.
    // Os métodos "get" retornam os valores atuais dos atributos: id, nome, embalagem e tamanho.
    // Os métodos "set" permitem definir (ou atualizar) os valores desses mesmos atributos.

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
    /**
     * Retorna uma representação textual da categoria no formato:
     * "nome - embalagem - tamanho".
     * 
     * @return String formatada da categoria
     */
    @Override
    public String toString() {
        return nome + " - " + embalagem + " - " + tamanho;
    }
}
