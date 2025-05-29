import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("+-------------------------+");
            System.out.println("1. Tính điểm sinh viên");
            System.out.println("2. Kiểm tra loại tam giác");
            System.out.println("3. Tính tiền điện");
            System.out.println("4. Kết thúc");
            System.out.println("+-------------------------+");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tinhDiemSinhVien();
                    break;
                case 2:
                    kiemTraLoaiTamGiac();
                    break;
                case 3:
                    tinhTienDien();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1–4.");
            }
            System.out.println(); // Dòng trắng giữa các lần lặp
        } while (choice < 1 || choice > 4);
    }

    // ------------------ Bài 1 ------------------
    public static void tinhDiemSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm chuyên cần: ");
        double cc = scanner.nextDouble();
        System.out.print("Nhập điểm giữa kỳ: ");
        double gk = scanner.nextDouble();
        System.out.print("Nhập điểm cuối kỳ: ");
        double ck = scanner.nextDouble();

        double tb = (cc + gk + ck) / 3;
        String xepLoai;
        if (tb >= 9) xepLoai = "A";
        else if (tb >= 7) xepLoai = "B";
        else if (tb >= 5) xepLoai = "C";
        else xepLoai = "D";

        System.out.printf("Điểm trung bình: %.2f → Xếp loại: %s\n", tb, xepLoai);
    }

    // ------------------ Bài 2 ------------------
    public static void kiemTraLoaiTamGiac() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập cạnh a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập cạnh b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập cạnh c: ");
        int c = scanner.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                System.out.println("Tam giác đều");
            } else if (a == b || b == c || a == c) {
                if (a * a + b * b == c * c ||
                        b * b + c * c == a * a ||
                        a * a + c * c == b * b) {
                    System.out.println("Tam giác vuông cân");
                } else {
                    System.out.println("Tam giác cân");
                }
            } else if (a * a + b * b == c * c ||
                    b * b + c * c == a * a ||
                    a * a + c * c == b * b) {
                System.out.println("Tam giác vuông");
            } else {
                System.out.println("Tam giác thường");
            }
        } else {
            System.out.println("Không phải tam giác");
        }
    }

    // ------------------ Bài 3 ------------------
    public static void tinhTienDien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện tiêu thụ (kWh): ");
        int kWh = scanner.nextInt();
        double tien = 0;

        if (kWh <= 0) tien = 0;
        else if (kWh <= 50)
            tien = kWh * 1678;
        else if (kWh <= 100)
            tien = 50 * 1678 + (kWh - 50) * 1734;
        else if (kWh <= 200)
            tien = 50 * 1678 + 50 * 1734 + (kWh - 100) * 2014;
        else if (kWh <= 300)
            tien = 50 * 1678 + 50 * 1734 + 100 * 2014 + (kWh - 200) * 2536;
        else if (kWh <= 400)
            tien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + (kWh - 300) * 2834;
        else
            tien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + 100 * 2834 + (kWh - 400) * 2927;

        System.out.printf("Tiền điện phải trả: %.0f VNĐ\n", tien);
    }
}
