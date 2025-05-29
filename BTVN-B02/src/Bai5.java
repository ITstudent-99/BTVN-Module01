import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập năm và tháng
        System.out.print("Nhập năm: ");
        int nam = scanner.nextInt();

        System.out.print("Nhập tháng (1-12): ");
        int thang = scanner.nextInt();

        int soNgay = 0;

        if(thang < 1 || thang > 12) {
            System.out.println("Tháng không hợp lệ. Vui lòng nhập từ 1 đến 12.");
            return;
        }

        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                soNgay = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                soNgay = 30;
            case 2:
                if (nam % 4 == 0 && nam % 100 != 0 || nam % 400 == 0) {
                    soNgay = 29;
                } else {
                    soNgay = 28;
                }
                break;
        }

        System.out.printf("Tháng %d năm %d có %d ngày.\n", thang, nam, soNgay);
        scanner.close();
    }
}
