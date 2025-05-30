public class Bai1BTC {
    public static void main(String[] args) {
        String str = "Tôi học lập trình, học lập trình rất hay";

        String newStr = str.replaceAll(",", "");
        System.out.println(newStr);
        System.out.println("=========================");

        String[] arr = newStr.split(" ");
        int len = arr.length;

//        a) Đếm số lượng từng từ.
        String[] uniqueWords = new String[len];
        int[] counts = new int[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            int index = indexOf(uniqueWords, arr[i]);
            if (index == -1) {
                uniqueWords[uniqueCount] = arr[i];
                counts[uniqueCount] = 1;
                uniqueCount++;
            } else {
                counts[index]++;
            }
        }

        // In kết quả
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(uniqueWords[i] + " : " + counts[i]);
        }
    }

//    Tìm vị trí từ trong mảng uniqueWords
    private static int indexOf( String[] arr, String word){
        int lengthArr = arr.length;
        for (int i = 0; i < lengthArr; i++) {
            if (arr[i] != null && arr[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
