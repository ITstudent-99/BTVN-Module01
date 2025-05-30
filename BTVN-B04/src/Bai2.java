import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so dien thoai: ");
        String phone = sc.nextLine();

//        Testcase C1
        if(checkPhone1(phone)){
            System.out.println("So dien thoai hop le");
        } else {
            System.out.println("So dien thoai khong hop le");
        }

//        TestCase C2
        if(checkPhone2(phone)){
            System.out.println("So dien thoai hop le");
        } else {
            System.out.println("So dien thoai khong hop le");
        }
        sc.close();
    }

//    Check phone number C1
    private static boolean checkPhone1(String phone) {
        if (phone == null) return false;

        // Bỏ dấu cách (nếu có)
        phone = phone.replaceAll(" ", "");

        // Các mẫu regex hợp lệ
        String[] validPatterns = {
                "^\\+84\\d{9}$",           // +84xxxxxxxxx
                "^84\\d{9}$",              // 84xxxxxxxxx
                "^0\\d{9}$",               // 0xxxxxxxxx
                "^0\\d{3}\\.\\d{3}\\.\\d{3}$",  // 0xxx.xxx.xxx
                "^0\\d{3}-\\d{3}-\\d{3}$",  // 0xxx-xxx-xxx
                "^0\\d{2}-\\d{3}-\\d{4}$"  // 0xx-xxx-xxxx
        };

        for (String pattern : validPatterns) {
            if (phone.matches(pattern)) {
                return true;
            }
        }
        return false;
    }

//    Check phone number C2
    private static boolean checkPhone2(String phone) {
        if (phone == null || phone.isEmpty()) return false;

        // Loai bo " ", -, .
        phone = phone.replaceAll("[\\s\\-\\.]", "");

        if (phone.startsWith("0")){
            phone = phone.substring(1);
        } else if (phone.startsWith("+84")){
            phone = phone.substring(3);
        } else if (phone.startsWith("84")){
            phone = phone.substring(2);
        } else {
            return false;
        }

        if (phone.length() != 9){
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
