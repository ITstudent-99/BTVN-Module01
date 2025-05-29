import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập điểm
        System.out.print("Nhập điểm chuyên cần: ");
        double chuyenCan = scanner.nextDouble();

        System.out.print("Nhập điểm giữa kỳ: ");
        double giuaKy = scanner.nextDouble();

        System.out.print("Nhập điểm cuối kỳ: ");
        double cuoiKy = scanner.nextDouble();

        // Tính điểm trung bình
        double diemTB = (chuyenCan + giuaKy + cuoiKy) / 3;

        // Xếp loại
        String xepLoai;
        if (diemTB >= 9) {
            xepLoai = "Loai A";
        } else if (diemTB >= 7) {
            xepLoai = "Loai B";
        } else if (diemTB >= 5) {
            xepLoai = "Loai C";
        } else {
            xepLoai = "Loai D";
        }

        // In kết quả
        System.out.printf("Diem trung binh: %.2f\n", diemTB);
        System.out.println("Xep loai: " + xepLoai);

        scanner.close();
    }
}
