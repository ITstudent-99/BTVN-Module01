import java.util.Scanner;

public class P2Cau3 {
    public static void main(String[] args) {
        final int ticketPrice = 10000;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tickets you wish to buy: ");
        int tickets = sc.nextInt();

        if (tickets > 10) {
            double price = ticketPrice * tickets * 0.8;
            System.out.println("The price is $" + price);
        } else if (tickets > 5) {
            double price = ticketPrice * tickets * 0.9;
            System.out.println("The price is $" + price);
        } else if (tickets > 0) {
            double price = ticketPrice * tickets;
            System.out.println("The price is $" + price);
        } else {
            System.out.println("tickets must be greater than 0");
        }
    }
}
