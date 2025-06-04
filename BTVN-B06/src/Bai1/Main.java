package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();

//        // ======= Tạo 2 đối tượng Dog =======
        Dog dog1 = new Dog("Rex", 3, "Chó", "Nâu", "Husky");
        Dog dog2 = new Dog("Lucky", 2, "Chó", "Đen", "Poodle");

        // ======= Tạo 2 đối tượng Cat =======
        Cat cat1 = new Cat("Mimi", 1, "Mèo", "Trắng", "Anh lông ngắn");
        Cat cat2 = new Cat("Tom", 4, "Mèo", "Xám", "Mèo mướp");

        // ======= Tạo 2 đối tượng Bird =======
        Bird bird1 = new Bird("Chích Bông", 1, "Chim", "Vàng", 1);
        Bird bird2 = new Bird("Sáo", 2, "Chim", "Đen", 2);

        // ======= Thêm vào Zoo =======
        zoo.addAnimal(dog1);
        zoo.addAnimal(dog2);
        zoo.addAnimal(cat1);
        zoo.addAnimal(cat2);
        zoo.addAnimal(bird1);
        zoo.addAnimal(bird2);

//        System.out.print("Bạn muốn nhập bao nhiêu động vật? ");
//        int n = Integer.parseInt(sc.nextLine());
//
//        for (int i = 0; i < n; i++) {
//            System.out.println("Nhập loại động vật (dog, cat, bird): ");
//            String type = sc.nextLine().toLowerCase();
//
//            Animal animal = null;
//
//            switch(type) {
//                case "dog":
//                    animal = new Dog();
//                    break;
//                case "cat":
//                    animal = new Cat();
//                    break;
//                case "bird":
//                    animal = new Bird();
//                    break;
//                default:
//                    System.out.println("Loại không hợp lệ, nhập lại.");
//                    i--; // giảm i để nhập lại
//                    continue;
//            }
//
//            animal.inputInfo(); // gọi phương thức nhập thông tin
//            zoo.addAnimal(animal); // thêm vào zoo
//        }

        zoo.displayAllInfo();
        zoo.makeAllSound();

        int size = zoo.getAnimals().size();
        System.out.println("=== Birds Fly ===");
        for (int i = 0; i < size; i++) {
            Animal animal = zoo.getAnimals().get(i);
            if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                bird.fly();
            }
        }

//        for (Animal animal : zoo.getAnimals()) {
//            if (animal instanceof Bird) {
//                ((Bird) animal).fly();
//            }
//        }
    }
}
