
package modelo;

/**
 * Classe que representa um produto no sistema de controle de estoque.
 * Contém informações como nome, preço, quantidade, limites mínimos e máximos,
 * unidade de medida e a categoria associada.
 * @author luiz
 */
public class CadastrarProduto {
    // Atributos principais do produto

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private int min;
    private int max;
    private String unidade;
    private CadastrarCategoria categoria;
    /**
     * Construtor padrão que inicializa os campos com valores padrão.
     */
    public CadastrarProduto() {
        this(0, "", 0.0, 0, 0, 0, "", null);
    }
    /**
     * Construtor que inicializa todos os atributos do produto.
     * 
     * @param id ID do produto
     * @param nome Nome do produto
     * @param preco Preço do produto
     * @param quantidade Quantidade em estoque
     * @param min Quantidade mínima permitida
     * @param max Quantidade máxima permitida
     * @param unidade Unidade de medida
     * @param categoria Categoria associada ao produto
     */
    public CadastrarProduto(int id, String nome, double preco, int quantidade, int min, int max, String unidade, CadastrarCategoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.min = min;
        this.max = max;
        this.unidade = unidade;
        this.categoria = categoria;
    }

    // Getters e Setters
    // Os métodos abaixo permitem acessar e modificar os atributos da categoria.
    // Os métodos "get" retornam os valores atuais dos atributos: id, nome, preco, quantidade, min, max, unidade e categoria.
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public CadastrarCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(CadastrarCategoria categoria) {
        this.categoria = categoria;
    }

    public int getCategoriaId() {
        return this.categoria != null ? this.categoria.getId() : 0;
    }
    /**
     * Retorna uma representação textual do produto para facilitar a visualização.
     * 
     * @return String formatada com os dados do produto
     */
    @Override
    public String toString() {
        return "Produto{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", preco=" + preco
                + ", quantidade=" + quantidade
                + ", min=" + min
                + ", max=" + max
                + ", unidade='" + unidade + '\''
                + ", categoria=" + (categoria != null ? categoria.getNome() : "Nenhuma")
                + '}';
    }
    /**
    * Calcula o valor total do estoque para a instância atual do produto/item.
    * Este método determina o valor monetário total do estoque ao multiplicar
    * a quantidade atual de itens disponíveis (`getQuantidade()`) pelo seu
    * preço unitário (`getPreco()`)
    */
    public Object getValorTotal() {
        return (int) (getQuantidade() * getPreco());
     }
}
