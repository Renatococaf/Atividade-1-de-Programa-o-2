package Atividade02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Classe principal para executar a aplicação
public class TaxCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            sc.nextLine(); // Consome a quebra de linha

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayers.add(new Individual(name, annualIncome, healthExpenditures));
            } else if (type == 'c') {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayers.add(new Company(name, annualIncome, numberOfEmployees));
            } else {
                System.out.println("Invalid type. Please enter 'i' or 'c'.");
                i--; // Repete a iteração se o tipo for inválido
            }
        }

        System.out.println("\nTAXES PAID:");
        double totalTaxes = 0.0;
        for (TaxPayer taxPayer : taxPayers) {
            double taxPaid = taxPayer.tax();
            System.out.printf("%s: $ %.2f%n", taxPayer.getName(), taxPaid);
            totalTaxes += taxPaid;
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f%n", totalTaxes);

        sc.close();
    }
}