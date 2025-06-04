import java.util.Scanner;
import java.util.Arrays;

public class P4Cau1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        1.	Nhập vào số lượng phần tử mảng.
//        2.	Nhập các phần tử mảng
        int[] arr = enterArray();
        printArray(arr);

//        3.	Tìm giá trị lớn nhất và giá trị nhỏ nhất và in ra kết quả.
        int max = findMax(arr);
        System.out.println("Maximum number is " + max);

        int min = findMin(arr);
        System.out.println("Minimum number is " + min);

//        4.	Tính tổng các phần tử của mảng
        int sum = calculateSum(arr);
        System.out.println("Sum of all numbers is " + sum);

//        5.	Thêm 1 phần tử vào mảng với vị trí do người dùng nhập, nếu mảng không đủ ô nhớ sẽ tự động tăng thêm 100% ô nhớ hiện tại.

        int size = arr.length;
        int capacity = size; // ban đầu capacity = size

        ArrayData result = addElement(arr, size, capacity);
        arr = result.arr;
        size = result.size;
        capacity = result.capacity;
        printArray(arr);

        // Có thể gọi tiếp:
        result = addElement(arr, size, capacity);
        arr = result.arr;
        size = result.size;
        capacity = result.capacity;
        printArray(arr);

//        6.	Cho người dùng nhập vào 1 phần tử, xóa đi tất cả các phần tử đó trong mảng
        System.out.print("Nhập giá trị muốn xóa: ");
        int deleteValue = sc.nextInt();

        arr = deleteElement(arr, deleteValue);
        printArray(arr);

//        7.	Tìm phần tử lớn thứ 3 trong mảng
        Integer thirdMax = findThirdMax(arr);
        if (thirdMax != null) {
            System.out.println("Phần tử lớn thứ 3 là: " + thirdMax);
        }
    }

    public static int[] enterArray() {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter number: ");
            num = sc.nextInt();
        } while (num <= 0);

        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("Nhap vao ptu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void printArray(int[] arr) {
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int calculateSum(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static ArrayData addElement(int[] arr, int size, int capacity) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vị trí muốn thêm phần tử (0 đến " + size + "): ");
        int position = sc.nextInt();
        if (position < 0 || position > size) {
            System.out.println("Vị trí không hợp lệ.");
            return new ArrayData(arr, size, capacity);
        }

        System.out.print("Nhập giá trị muốn thêm: ");
        int value = sc.nextInt();

        if (size == capacity) {
            capacity *= 2;
            arr = Arrays.copyOf(arr, capacity);
        }

        for (int i = size; i > position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = value;
        size++;

        return new ArrayData(arr, size, capacity);
    }

    public static int[] deleteElement(int[] arr, int value) {
        int size = arr.length;
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != value) {
                arr[newSize] = arr[i];
                newSize++;
            }
        }
        return Arrays.copyOf(arr, newSize);
    }

    public static void sortArray(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static Integer findThirdMax(int[] arr) {
        int size = arr.length;
        if (size < 3) {
            System.out.println("Không đủ phần tử để tìm phần tử lớn thứ 3.");
            return null;
        }
        int[] copy = Arrays.copyOf(arr, size);
        sortArray(copy);
        System.out.print("Mang sau khi sap xep giam dan: ");
        printArray(copy);

        return copy[2];
    }
}

class ArrayData {
    int[] arr;
    int size;
    int capacity;

    ArrayData(int[] a, int s, int c) {
        this.arr = a;
        this.size = s;
        this.capacity = c;
    }
}