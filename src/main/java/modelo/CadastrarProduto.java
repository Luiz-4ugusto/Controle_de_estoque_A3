/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author luiz
 */
public class CadastrarProduto {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private int min;
    private int max;
    private String unidade;
    private Cadastrar categoria;

    public CadastrarProduto() {
        this(0, "", 0.0, 0, 0, 0, "", null);
    }

    public CadastrarProduto(int id, String nome, double preco, int quantidade, int min, int max, String unidade, Cadastrar categoria) {
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

    public Cadastrar getCategoria() {
        return categoria;
    }

    public void setCategoria(Cadastrar categoria) {
        this.categoria = categoria;
    }

    public int getCategoriaId() {
        return this.categoria != null ? this.categoria.getId() : 0;
    }

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
}
