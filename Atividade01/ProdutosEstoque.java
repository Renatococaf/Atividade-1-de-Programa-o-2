package Atividade01;

import java.util.Scanner;

public class ProdutosEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product data: ");
        System.out.println("Name: ");
        String nome = scanner.nextLine();
        System.out.println("Price: ");
        float preco = scanner.nextFloat();
        System.out.println("Quantity in stock: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, preco, quantidade);
        System.out.println("Product data: " + produto);

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
                produto.addQuantidade(produto.getQuantidade() + produtosAdd);

                System.out.println("Update data: " + produto);
            }
            else if (resposta == 'b') {
                System.out.println("Enter the quantity to remove from stock:");
                int produtosRem = scanner.nextInt();
                produto.removerEstoque(produtosRem);

                System.out.println("Update data: " + produto);
            }
        }
        while (resposta != 'c');

        System.out.println("Stock update completed.");
        scanner.close();
        
    }

}