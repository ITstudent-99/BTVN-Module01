public class Bai1 {
    public static void main(String[] args) {
        String str = "Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun" +
                " Microsystems do James Gosling khởi xướng và phát hành vào " +
                "năm 1995. Phiên bản mới nhất của Java Standard Edition là " +
                "Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi " +
                "của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều" +
                " loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh" +
                " nghiệp, J2ME cho các ứng dụng di động.";

        String[] arr = str.split(" ");

//      1.	Đếm số lượng từng từ trong đoạn văn (không phân biệt hoa thường).
        int count = 0;
        for (String s : arr) {
            count++;
        }

        System.out.println("So luong ky tu: " + count);

//      2.	Viết hoa chữ cái đầu trong mỗi từ.
        String upperCaseStr = "";
        for (String s : arr) {
            upperCaseStr += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
        }
        System.out.println("Viet Hoa ky tu dau: " + upperCaseStr);

//       3.	Xóa các nguyên âm trong câu.

//      Cach 1
//      Regex chứa tất cả nguyên âm tiếng Việt (có dấu và không dấu)
        String regex = "[aeiouyăâêôơưàáảãạằắẳẵặầấẩẫậèéẻẽẹềếểễệ"
                + "ìíỉĩịòóỏõọồốổỗộờớởỡợùúủũụừứửữựỳýỷỹỵ"
                + "AEIOUYĂÂÊÔƠƯÀÁẢÃẠẰẮẲẴẶẦẤẨẪẬÈÉẺẼẸỀẾỂỄỆ"
                + "ÌÍỈĨỊÒÓỎÕỌỒỐỔỖỘỜỚỞỠỢÙÚỦŨỤỪỨỬỮỰỲÝỶỸỴ]";

        String noVowelStr = str.replaceAll(regex, "");

        System.out.println("No vowel: " + noVowelStr);

//      Cach 2
        String text = "Ngôn ngữ lập trình Java rất phổ biến!";

        // Danh sách nguyên âm tiếng Việt (có thể mở rộng thêm)
        String vowels = "aeiouyăâêôơưàáảãạằắẳẵặầấẩẫậèéẻẽẹềếểễệ" +
                "ìíỉĩịòóỏõọồốổỗộờớởỡợùúủũụừứửữựỳýỷỹỵ" +
                "AEIOUYĂÂÊÔƠƯÀÁẢÃẠẰẮẲẴẶẦẤẨẪẬÈÉẺẼẸỀẾỂỄỆ" +
                "ÌÍỈĨỊÒÓỎÕỌỒỐỔỖỘỜỚỞỠỢÙÚỦŨỤỪỨỬỮỰỲÝỶỸỴ";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // Nếu ký tự không phải nguyên âm thì giữ lại
            if (vowels.indexOf(c) == -1) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
