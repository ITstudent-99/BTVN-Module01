import java.util.Scanner;

public abstract class Book {
    private int id;
    private String title;
    private int year;
    private String author;

    public Book() {}

    public Book(int id, String title, int year, String author) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Author: " + author);
    };

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        id = Integer.parseInt(scanner.nextLine());  // dùng nextLine + parseInt

        System.out.print("Enter book title: ");
        title = scanner.nextLine();

        System.out.print("Enter publication year: ");
        year = Integer.parseInt(scanner.nextLine()); // đảm bảo không bị skip

        System.out.print("Enter author name: ");
        author = scanner.nextLine();
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class BusinessBook extends Book {
    private String businessField;

    public BusinessBook() {}

    public BusinessBook(int id, String title, int year, String author, String businessField) {
        super(id, title, year, author);
        this.businessField = businessField;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Business Field: " + businessField);
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter business field: ");
        businessField = scanner.nextLine();
    }
}

class ScienceBook extends Book {
    private String researchSubject;

    public ScienceBook() {}
    public ScienceBook(int id, String title, int year, String author, String researchSubject) {
        super(id, title, year, author);
        this.researchSubject = researchSubject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Subject: " + researchSubject);
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter research subject: ");
        researchSubject = scanner.nextLine();
    }
}


