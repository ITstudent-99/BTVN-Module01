public interface ILibrary {
    void addBook(Book book);

    void updateBook(int id, Book bookUpdate);

    void deleteBook(int id);

    void searchByAuthor(String author);

    void displayAllBooks();
}
