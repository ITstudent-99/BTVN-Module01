import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String soNhiPhan = "";
        int n;
        do {
            System.out.print("Nhap vao mot so nguyen: ");
            n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Nhap la so nguyen!");
            }
        } while (n < 0);


        while (n > 0){
            int soDu = n % 2;
            soNhiPhan = soDu + soNhiPhan;
            n = n / 2;
        }

        System.out.println("Biểu diễn nhị phân của " + n + " là: " + soNhiPhan);

        scanner.close();
    }
}
