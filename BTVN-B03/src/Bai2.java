import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        int reversed = 0;

        do {
            System.out.print("Nhập vào một số nguyên: ");
            number = scanner.nextInt();
        } while (number <= 0);

        int digit;
        while (number > 0) {
            digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Số đảo ngược: " + reversed);
        scanner.close();
    }
}
