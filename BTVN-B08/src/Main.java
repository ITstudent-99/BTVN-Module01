import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ILibrary library = new Library();

        // Tạo các sách cụ thể (không dùng input từ người dùng)
        Book book1 = new BusinessBook(1, "The Lean Startup", 2011, "Eric Ries", "Entrepreneurship");
        Book book2 = new ScienceBook(2, "A Brief History of Time", 1988, "Stephen Hawking", "Cosmology");
        Book book3 = new BusinessBook(3, "Zero to One", 2014, "Peter Thiel", "Startup Strategy");
        Book book4 = new ScienceBook(4, "The Selfish Gene", 1976, "Richard Dawkins", "Evolutionary Biology");

        // Thêm sách vào thư viện
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book by Author");
            System.out.println("5. Display All Books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Add Book
                    Book newBook = inputBook();
                    if (newBook != null) {
                        library.addBook(newBook);
                    }
                    break;

                case 2:
                    // Update Book
                    System.out.print("Enter book ID to update: ");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    // Kiểm tra ID tồn tại trước
                    if (!(library instanceof Library) || !((Library) library).existsById(updateId)) {
                        System.out.println("Book with ID " + updateId + " not found.");
                        break;
                    }

                    Book updatedBook = inputBook();
                    // Lưu ý: bookUpdate phải có đúng ID cần update
                    updatedBook.setId(updateId);
                    library.updateBook(updateId, updatedBook);
                    break;

                case 3:
                    // Delete Book
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    library.deleteBook(deleteId);
                    break;

                case 4:
                    // Search by Author
                    System.out.print("Enter author name to search: ");
                    String author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;

                case 5:
                    // Display All Books
                    library.displayAllBooks();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Book inputBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select book type:");
        System.out.println("1. Business Book");
        System.out.println("2. Science Book");
        System.out.print("Your choice: ");
        int type = Integer.parseInt(scanner.nextLine());

        Book book;
        switch (type) {
            case 1:
                book = new BusinessBook();
                break;
            case 2:
                book = new ScienceBook();
                break;
            default:
                System.out.println("Invalid book type.");
                return null;
        }
        book.inputInfo(); // Gọi để nhập thông tin sách
        return book;
    }
}


