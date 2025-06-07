public class Library implements ILibrary{
    private Book[] books;
    private int count;

    public Library() {
        this.books = new Book[10];
    }
    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    @Override
    public void addBook(Book book) {
        // Kiểm tra ID trùng
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == book.getId()) {
                System.out.println("Book with ID " + book.getId() + " already exists.");
                return;
            }
        }

        // Thêm sách nếu chưa trùng và còn chỗ
        if (count < books.length) {
            books[count++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    @Override
    public void updateBook(int id, Book bookUpdate) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                books[i] = bookUpdate;
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    @Override
    public void deleteBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                count--;
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    @Override
    public void searchByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i] != null && books[i].getAuthor().toLowerCase().contains(author.toLowerCase())) {
                books[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }


    @Override
    public void displayAllBooks() {
        if (count == 0) {
            System.out.println("Library is empty.");
        } else {
            for (int i = 0; i < count; i++) {
                books[i].displayInfo();
            }
        }
    }

    public boolean existsById(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
}
