package Atividade01;

public class Produto {
    private String nome;
    private float preco;
    private int quantidade;

    public Produto(String nome, float preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorTotalEmEstoque() {
        return preco * quantidade;
    }

    public void addQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > this.quantidade) {
            System.out.println("Insufficient stock to remove " + quantidade + " units.");
        } else {
            this.quantidade -= quantidade;
        }
    }
    @Override
    public String toString() {
        return String.format("Product: %s, Price: $%.2f, Quantity: %d, Total Value: $%.2f",
                nome, preco, quantidade, getValorTotalEmEstoque());
    }

}