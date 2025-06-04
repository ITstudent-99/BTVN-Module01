import java.util.Scanner;

public class P2Cau1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the int number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

        sc.close();
    }
}
