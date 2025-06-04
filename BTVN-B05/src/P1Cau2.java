import java.util.Scanner;

public class P1Cau2 {

    public static double PI = 3.14;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập vào bán kính hình tròn
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        // 2. Tính diện tích hình tròn (S = π * r^2)
        double area = PI * radius * radius;
        System.out.printf("The area of the circle is %.2f\n", area);

        // 3. Kiểm tra diện tích là chẵn hay lẻ
        // Chúng ta chuyển diện tích sang int để kiểm tra chẵn lẻ
        int areaInt = (int) area;

        if (areaInt % 2 == 0) {
            System.out.println("Phần nguyên của diện tích là số chẵn.");
        } else {
            System.out.println("Phần nguyên của diện tích là số lẻ.");
        }

        sc.close();
    }
}
