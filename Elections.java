import java.util.Scanner;

public class Elections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int votosPSDB = 0;
        int votosPMDB = 0;
        int votosNulos = 0;

        System.out.print("Digite o número de eleitores: ");
        int totalEleitores = scanner.nextInt();

        for (int i = 1; i <= totalEleitores; i++) {
            System.out.print("Voto do eleitor #" + i + ": ");
            int voto = scanner.nextInt();

            if (voto == 45) {
                votosPSDB++;
            } else if (voto == 15) {
                votosPMDB++;
            } else {
                votosNulos++;
            }
        }

        int votosValidos = votosPSDB + votosPMDB;

        System.out.println("\nResultado da eleição:");
        System.out.println("PSDB (45): " + votosPSDB + " voto(s)");
        System.out.println("PMDB (15): " + votosPMDB + " voto(s)");
        System.out.println("Nulos: " + votosNulos + " voto(s)");

        // Verifica se a eleição deve ser cancelada
        if (votosValidos == 0 || votosNulos > (votosValidos / 2.0)) {
            System.out.println("A eleição foi cancelada devido ao número excessivo de votos nulos.");
        } else {
            if (votosPSDB > votosPMDB) {
                System.out.println("Vencedor: PSDB (45)");
            } else if (votosPMDB > votosPSDB) {
                System.out.println("Vencedor: PMDB (15)");
            } else {
                System.out.println("Empate entre PSDB e PMDB.");
            }
        }

        scanner.close();
    }
}