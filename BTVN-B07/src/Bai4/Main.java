package Bai4;

public class Main {

    public static void main(String[] args) {
        // Tạo đối tượng Account với thông tin như yêu cầu
        Account acc = new Account(1122, 20000, 4.5);

        // Rút 2500 USD
        acc.withdraw(2500);

        // Gửi 3000 USD
        acc.deposit(3000);

        // In ra thông tin
        System.out.println("Số dư hiện tại: $" + acc.getBalance());
        System.out.println("Tiền lãi hàng tháng: $" + acc.getMonthlyInterest());
        System.out.println("Ngày tạo tài khoản: " + acc.getDateCreated());
    }
}
