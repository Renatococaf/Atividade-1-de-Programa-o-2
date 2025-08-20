import java.util.Scanner;

public class main_with_classTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrar com as medidas de X:");
        double aX = sc.nextDouble();
        double bX = sc.nextDouble();
        double cX = sc.nextDouble();
        Triangle x = new Triangle(aX, bX, cX);

        System.out.println("Entrar com as medidas de Y:");
        double aY = sc.nextDouble();
        double bY = sc.nextDouble();
        double cY = sc.nextDouble();
        Triangle y = new Triangle(aY, bY, cY);

        System.out.printf("Área do triângulo X: %.4f%n", x.area());
        System.out.printf("Área do triângulo Y: %.4f%n", y.area());

        if (x.area() > y.area()) {
            System.out.println("Maior área: X");
        } else if (x.area() < y.area()) {
            System.out.println("Maior área: Y");
        } else {
            System.out.println("Ambas as áreas são iguais");
        }

        sc.close();
    }
}

// Classe Triangle para cálculo da área usando a fórmula de Heron
class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

//UML saber o que é...//