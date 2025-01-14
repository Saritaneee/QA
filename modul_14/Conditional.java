import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan angka (1-10): ");
        int x = scanner.nextInt();

        if (x >= 1) {
            if (x <= 10) {
                if (x % 2 == 0) {
                    System.out.println(x + " genap");
                } else if (x % 2 != 0) {
                    System.out.println(x + " ganjil");
                }
            } else {
                System.out.println("Diluar jangkauan");
            }
        } else {
            System.out.println("Diluar jangkauan");
        }
        //Apakah bisa dibuat lebih simpel?
    }
}
