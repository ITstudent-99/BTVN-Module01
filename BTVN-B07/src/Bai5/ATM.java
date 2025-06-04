package Bai5;

import java.util.Scanner;
import Bai4.Account;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[10];

        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100, 0);
        }

        int id;
        do {
            System.out.print("Nhập ID tài khoản (0-9): ");
            id = sc.nextInt();
        } while (id < 0 || id > 10);

        // Tài khoản hợp lệ
        Account currentAccount = accounts[id];

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Xem số dư");
            System.out.println("2. Rút tiền");
            System.out.println("3. Gửi tiền");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Số dư hiện tại: $" + currentAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Nhập số tiền cần rút: ");
                    double withdrawAmount = sc.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Nhập số tiền cần gửi: ");
                    double depositAmount = sc.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;

                case 4:
                    System.out.println("Đăng xuất khỏi tài khoản...\n");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

            if (choice == 4) {
                break;
            }
        }
        sc.close();
    }
}
