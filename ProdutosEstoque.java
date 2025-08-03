import java.util.Scanner;

public class ProdutosEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Product Inventory System!!");
        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        String nome = scanner.nextLine();
        System.out.println("Price: ");
        float preco = scanner.nextFloat();
        System.out.println("Quantity in stock: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, preco, quantidade);
        System.out.printf(
                "Product Data: %s, $%.2f, %d units, Total: $%.2f\n",
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade(),
                produto.getValorTotalEmEstoque()
        );

        char resposta;
        do {
            System.out.println("\nWhat do you want to do?");
            System.out.println("a) Add more products to stock");
            System.out.println("b) Remove products from stock");
            System.out.println("c) Finish the program");
            resposta = scanner.next().toLowerCase().charAt(0); // converte pra minúsculo

            if (resposta == 'a') {
                System.out.println("Enter the quantity to add to stock:");
                int produtosAdd = scanner.nextInt();
                produto.setQuantidade(produto.getQuantidade() + produtosAdd);

                System.out.printf("Updated data: %s, $%.2f, %d units, Total: $%.2f\n",
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getQuantidade(),
                        produto.getValorTotalEmEstoque()
                );
            } else if (resposta == 'b') {
                System.out.println("Enter the quantity to remove from stock:");
                int produtosRem = scanner.nextInt();
                produto.removerEstoque(produtosRem);

                System.out.printf("Updated data: %s, $%.2f, %d units, Total: $%.2f\n",
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getQuantidade(),
                        produto.getValorTotalEmEstoque()
                );
            }
        } while (resposta != 'c');

        System.out.println("Stock update completed.");
        scanner.close();
    }

    public static class Produto {
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

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public void removerEstoque(int quantidade) {
            if (quantidade > this.quantidade) {
                System.out.println("Insufficient stock to remove " + quantidade + " units.");
            } else {
                this.quantidade -= quantidade;
            }
        }
    }
}