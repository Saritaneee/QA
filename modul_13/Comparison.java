import java.util.Scanner;

public class Comparison {
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan bilangan pertama: ");
        a = scanner.nextInt();
        System.out.println("Masukkan bilangan kedua: ");
        b = scanner.nextInt();

        System.out.println(a + " == " + b + ": " + (a == b));
        System.out.println(a + " != " + b + ": " + (a != b));
        System.out.println(a + " > " + b + ": " + (a > b));
        System.out.println(a + " >= " + b + ": " + (a >= b));
        System.out.println(a + " < " + b + ": " + (a < b));
        System.out.println(a + " <= " + b + ": " + (a <= b));


    }
}
