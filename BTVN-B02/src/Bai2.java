import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        // Nhap 3 canh cua tam giac
        System.out.println("Nhap vao 3 canh cua tam giac: ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();
        System.out.print("c: ");
        int c = scanner.nextInt();

        if (isTamGiac(a, b, c)){
            if (isTamGiacDeu(a, b, c)) {
                System.out.println("Tam giác đều");
            } else if (isTamGiacVuongCan(a, b, c)) {
                System.out.println("Tam giác vuông cân");
            } else if (isTamGiacVuong(a, b, c)) {
                System.out.println("Tam giác vuông");
            } else if (isTamGiacCan(a, b, c)) {
                System.out.println("Tam giác cân");
            } else {
                System.out.println("Tam giác thường");
            }
        } else {
            System.out.println("Không phải tam giác");
        }
    }

    public static boolean isTamGiac(int a, int b, int c) {
        return (a < b + c && b < a + c && c < a + b);
    }

    public static boolean isTamGiacVuong(int a, int b, int c) {
        return a * a + b * b == c * c || b * b + c * c == a * a || a * a + c * c == b * b;
    }

    public static boolean isTamGiacCan(int a, int b, int c) {
        return a == b || b == c || a == c;
    }

    public static boolean isTamGiacVuongCan(int a, int b, int c) {
        return isTamGiacVuong(a, b, c) && isTamGiacCan(a, b, c);
    }

    public static boolean isTamGiacDeu(int a, int b, int c) {
        return a == b && b == c;
    }
}
