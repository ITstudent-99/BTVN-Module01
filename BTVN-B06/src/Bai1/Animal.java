package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;
    private String species;
    private String color;

    public Animal() {
        // constructor rỗng để dùng khi inputInfo()
    }

    public Animal(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    // Phương thức trừu tượng
    public abstract void makeSound();

    // Nhập thông tin
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập loài: ");
        species = sc.nextLine();

        System.out.print("Nhập màu sắc: ");
        color = sc.nextLine();
    }

    // Hiển thị thông tin
    public void displayInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Loài: " + species);
        System.out.println("Màu sắc: " + color);
    }

    // Getter & Setter (nếu cần truy cập từ lớp con)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tên: " + name +
                "\nTuổi: " + age +
                "\nLoài: " + species +
                "\nMàu sắc: " + color;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog() {
        super(); // Gọi constructor rỗng của Animal
    }

    public Dog(String name, int age, String species, String color, String breed) {
        super(name, age, species, color);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giống chó (breed): ");
        breed = sc.nextLine();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống chó: " + breed);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGiống chó: " + breed;
    }
}

class Cat extends Animal {
    private String breed;

    public Cat() {}
    public Cat(String name, int age, String species, String color, String breed) {
        super(name, age, species, color);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap giong meow (breed): ");
        breed = sc.nextLine();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giong meow: " + breed);
    }

    @Override
    public String toString() {
        return super.toString() + "\nGiong meow: " + breed;
    }
}

class Bird extends Animal {
    private int wingSpan;

    public Bird() {}
    public Bird(String name, int age, String species, String color,
                int wingSpan) {
        super(name, age, species, color);
        this.wingSpan = wingSpan;
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Tweet!");
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap sai canh (wingSpan): ");
        wingSpan = sc.nextInt();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sai canh: " + wingSpan + "met");
    }

    @Override
    public String toString() {
        return super.toString() + "\nSai canh: " + wingSpan + " met";
    }

    // Thêm phương thức fly()
    public void fly() {
        System.out.println(getName() + " đang bay trên không trung!");
    }
}

class Zoo {
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public Zoo() {};

//    getter method
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void makeAllSound() {
        System.out.println("=== Âm thanh các động vật ===");
        for (Animal a : this.animals) {
            System.out.print(a.getName() + ": ");
            a.makeSound();
        }
    }

    public void displayAllInfo() {
        for (Animal a : this.animals) {
            a.displayInfo();
        }
    }
}

class ZooAdvanced extends Zoo {
    public ZooAdvanced() {
        super();
    };

    // Phương thức nhập số lượng động vật và nhập info từng con
    public void inputAnimals() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng động vật muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin động vật thứ " + (i + 1));
            System.out.print("Chọn loại động vật (1. Dog, 2. Cat, 3. Bird): ");
            int choice = Integer.parseInt(sc.nextLine());

            Animal animal = null;
            switch (choice) {
                case 1:
                    animal = new Dog();
                    break;
                case 2:
                    animal = new Cat();
                    break;
                case 3:
                    animal = new Bird();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, bỏ qua.");
                    i--; // không tính lần nhập này
                    continue;
            }
            animal.inputInfo();
            addAnimal(animal);
            System.out.println("Đã thêm thành công!\n");
        }
    }

    public void sortAnimalsByAge() {
        ArrayList<Animal> animals = this.getAnimals();
        int n = animals.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (animals.get(j).getAge() > animals.get(j + 1).getAge()) {
                    // Hoán đổi vị trí
                    Animal temp = animals.get(j);
                    animals.set(j, animals.get(j + 1));
                    animals.set(j + 1, temp);
                }
            }
        }
    }

}