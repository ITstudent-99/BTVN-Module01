import java.util.ArrayList;

public class LibraryWithArrayListBooks implements ILibrary {
    private ArrayList<Book> books;

    public LibraryWithArrayListBooks() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("Book with ID " + book.getId() + " already exists.");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    @Override
    public void updateBook(int id, Book bookUpdate) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.set(i, bookUpdate);
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    @Override
    public void deleteBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    @Override
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                b.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    @Override
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (Book b : books) {
                b.displayInfo();
            }
        }
    }
}
