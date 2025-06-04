import java.util.Scanner;

public class P3Cau2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("String: " + s);

        int len = s.length();

        boolean isDoiXung = true;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                isDoiXung = false;
                break;
            }
        }

        if (isDoiXung) {
            System.out.println("Doi Xung");
        } else {
            System.out.println("Khong Doi Xung");
        }

        // 2. Sử dụng StringBuilder để đảo ngược chuỗi
        String reversed = new StringBuilder(s).reverse().toString();

        // 3. So sánh chuỗi ban đầu và chuỗi đảo ngược
        if (s.equals(reversed)) {
            System.out.println("Chuỗi là Palindrome");
        } else {
            System.out.println("Chuỗi không phải là Palindrome");
        }

        sc.close();
    }
}
