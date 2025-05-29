import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Nhập n, kiểm tra n phải > 0
        do {
            System.out.print("Nhập số nguyên dương n: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Giá trị n phải lớn hơn 0. Vui lòng nhập lại.");
            }
        } while (n <= 0);

        int tong = 0;
        for(int i = 1; i <= n; i++) {
            tong += i * i * i;
        }

        System.out.println("Tổng S(n) = 1³ + 2³ + ... + " + n + "³ = " + tong);
        scanner.close();
    }
}
