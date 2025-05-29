import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số kWh
        System.out.print("Nhập số điện sử dụng trong tháng (kWh): ");
        int kWh = scanner.nextInt();
        double tienDien;

        if (kWh <= 0) {
            tienDien = 0;
        } else {
            if (kWh <= 50) {
                tienDien = kWh * 1678;
            } else if (kWh <= 100) {
                tienDien = 50 * 1678 + (kWh - 50) * 1734;
            } else if (kWh <= 200) {
                tienDien = 50 * 1678 + 50 * 1734 + (kWh - 100) * 2014;
            } else if (kWh <= 300) {
                tienDien = 50 * 1678 + 50 * 1734 + 100 * 2014 + (kWh - 200) * 2536;
            } else if (kWh <= 400) {
                tienDien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + (kWh - 300) * 2834;
            } else {
                tienDien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + 100 * 2834 + (kWh - 400) * 2927;
            }
        }

        System.out.printf("Tiền điện phải trả: %.0f VNĐ\n", tienDien);
        scanner.close();
    }
}
