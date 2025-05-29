public class Bai4 {
    public static void main(String[] args) {
        int count = 0;

        for(int x = 0; x <= 200; x++){
            for(int y = 0; y <= 100; y++){
                for (int z = 0; z <= 40; z++){
                    if(x * 1000 + y * 2000 + z * 5000 == 200000){
                        System.out.printf("1000đ: %3d, 2000đ: %3d, 5000đ: %3d\n", x, y, z);
                        count++;
                    }
                }
            }
        }

        System.out.println("Tổng số phương án: " + count);
    }
}
