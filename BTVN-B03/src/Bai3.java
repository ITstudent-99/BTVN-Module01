import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Nhập vào một số nguyên: ");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Vui lòng nhập số nguyên dương (n ≥ 0).");
            }
        } while (n < 0);

        int giaiThua = factorial(n);

        System.out.printf("%d! = %d\n", n, giaiThua);
        scanner.close();
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
