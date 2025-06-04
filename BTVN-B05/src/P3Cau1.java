import java.util.Scanner;
public class P3Cau1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Nhập vào một chuỗi
        System.out.print("Nhập vào một chuỗi: ");
        String input = scanner.nextLine();

        // Sử dụng StringBuilder để đảo ngược chuỗi
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();

        // In ra chuỗi đảo ngược
        System.out.println("Chuỗi đảo ngược là: " + reversed);

        // Đảo ngược chuỗi bằng vòng lặp
        String reversed2 = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed2 += input.charAt(i); // Cộng từng ký tự ngược vào chuỗi mới
        }

        // In ra chuỗi đảo ngược
        System.out.println("Chuỗi đảo ngược là: " + reversed2);

        scanner.close();
    }
}
