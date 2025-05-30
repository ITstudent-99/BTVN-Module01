import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        1.	Nhập một mảng các số nguyên.
        System.out.print("Nhap so luong phan tu trong mang: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            System.out.print("Nhap phan tu thu " + i + ": ");
            arr[i-1] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Mang la: ");
        printArr(arr);

//        2.	Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.
        System.out.println("Tong so chan: " + sumEven(arr));
        System.out.println("Tong so le: " + sumOdd(arr));

//        3.	Tìm và in ra các số nguyên tố có trong mảng.
        int[] printed = new int[arr.length]; // mảng lưu các số nguyên tố đã in
        int count = 0; // số lượng phần tử đã in
        System.out.print("Day so nguyen to trong mang la: ");
        for (int number : arr) {
            if (isPrime(number)) {
                boolean isExist = false;

                // Kiểm tra từ printed[0] -> printed[count - 1]
                for (int i = 0; i < count; i++) {
                    if (printed[i] == number) {
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    System.out.print(number + " ");
                    printed[count++] = number;
                }
            }
        }
        System.out.println();

//        4.	Sắp xếp mảng sao cho:
//                o	Các phần tử chẵn được sắp xếp theo thứ tự giảm dần.
//                o	Các phần tử lẻ được sắp xếp theo thứ tự tăng dần.
        int[] evenArr = getEven(arr);
        System.out.print("Mang chan: ");
        printArr(evenArr);
        int[] oddArr = getOdd(arr);
        System.out.print("Mang le: ");
        printArr(oddArr);

//        5.	Chia mảng thành 2 mảng con:
//                o	Mảng 1: Chứa tất cả các phần tử có giá trị nhỏ hơn hoặc bằng trung bình của mảng.
//                o	Mảng 2: Chứa tất cả các phần tử có giá trị lớn hơn trung bình của mảng.
        double avgValue = (double)(sumEven(arr) + sumOdd(arr)) / arr.length;
        int[] smallerThanAvgArr = smallerThanAvg(arr, avgValue);
        int[] largerThanAvgArr = largerThanAvg(arr, avgValue);
        System.out.print("Mang con la: ");
        printArr(smallerThanAvgArr);
        System.out.print("Mang con la: ");
        printArr(largerThanAvgArr);

//        6.	Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.
        printDuplicateElements(arr);

//        7.	Thêm một phần tử vào mảng tại vị trí chỉ định (index).
        int index;
        do {
            System.out.print("Nhập vị trí muốn thêm phần tử (0 đến " + arr.length + "): ");
            index = sc.nextInt();

            if (index < 0 || index > arr.length) {
                System.out.println("Vị trí không hợp lệ, vui lòng nhập lại.");
            }
        } while (index < 0 || index > arr.length);
        System.out.print("Nhap phan tu muon them: ");
        int value = sc.nextInt();
        int[] newArr = insertAt(arr, index, value);

        System.out.print("Mang moi la: ");
        printArr(newArr);

//        8.	Xoá một phần tử khỏi mảng.
        int indexRemove;
        do {
            System.out.print("Nhập vị trí muốn xoá (0 đến " + (arr.length - 1) + "): ");
            indexRemove = sc.nextInt();

            if (indexRemove < 0 || indexRemove >= arr.length) {
                System.out.println("Index không hợp lệ, vui lòng nhập lại.");
            }
        } while (indexRemove < 0 || indexRemove >= arr.length);

        int[] newRemoveArr = removeAt(arr, indexRemove);

        System.out.print("Mang moi la: ");
        printArr(newRemoveArr);
    }

    private static void printArr(int[] arr) {
        if (arr == null) return;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int sumEven(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private static int sumOdd(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 != 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int[] getEven(int[] arr) {
        if (arr == null) return null;

        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        if (count == 0) return null;

        int[] evenArr = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenArr[index++] = num;
            }
        }
        sortReverse(evenArr);
        return evenArr;
    }

    private static int[] getOdd(int[] arr) {
        if (arr == null) return null;
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
        }
        if (count == 0) return null;
        int[] oddArr = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                oddArr[index++] = num;
            }
        }
        sort(oddArr);
        return oddArr;
    }

    private static void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void sortReverse(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static int[] smallerThanAvg(int[] arr, double avgValue) {
        if (arr == null) return null;
        int len = arr.length;

        int count = 0;
        for (int num : arr) {
            if (num < avgValue) {
                count++;
            }
        }
        if (count == 0) return null;
        int[] smallerThanAvgArr = new int[count];
        int index = 0;
        for (int num : arr) {
            if ((double) num < avgValue) {
                smallerThanAvgArr[index++] = num;
            }
        }
        return smallerThanAvgArr;
    }

    private static int[] largerThanAvg(int[] arr, double avgValue) {
        if (arr == null) return null;
        int len = arr.length;
        int count = 0;
        for (int num : arr) {
            if (num > avgValue) {
                count++;
            }
        }
        if (count == 0) return null;
        int[] largerThanAvgArr = new int[count];
        int index = 0;
        for (int num : arr) {
            if ((double) num > avgValue) {
                largerThanAvgArr[index++] = num;
            }
        }
        return largerThanAvgArr;
    }

    // Hàm tách riêng: in ra các phần tử xuất hiện nhiều hơn 1 lần
    public static void printDuplicateElements(int[] arr) {
        boolean[] checked = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!checked[i]) {
                int count = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        checked[j] = true;
                    }
                }
                if (count > 1) {
                    System.out.println("Phần tử " + arr[i] + " xuất hiện " + count + " lần");
                }
            }
        }
    }

//    Trong Java, mảng có kích thước cố định, nên bạn không thể thêm trực
//    tiếp phần tử vào mảng hiện có mà phải tạo mảng mới có kích thước lớn hơn và sao chép các phần tử.
    public static int[] insertAt(int[] arr, int index, int value) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Index không hợp lệ");
        }

        int[] newArr = new int[arr.length + 1];

        // Copy các phần tử trước index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Thêm phần tử mới vào vị trí index
        newArr[index] = value;

        // Copy các phần tử còn lại (bắt đầu từ index của mảng cũ)
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

//    Java mảng có kích thước cố định, nên để xoá một phần tử khỏi mảng, bạn
//    phải tạo mảng mới có kích thước nhỏ hơn 1 và sao chép các phần tử còn lại (trừ phần tử cần xoá).
    public static int[] removeAt(int[] arr, int index) {

        int[] newArr = new int[arr.length - 1];

        // Copy các phần tử trước index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Copy các phần tử sau index
        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        return newArr;
    }
}
