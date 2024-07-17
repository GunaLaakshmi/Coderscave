import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, User> users;
    private Map<String, Book> books;

    public Library() {
        users = new HashMap<>();
        books = new HashMap<>();
    }

    // User management
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    // Book management
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }

    // Borrow book
    public boolean borrowBook(String userId, String bookId) {
        User user = getUser(userId);
        Book book = getBook(bookId);

        if (user != null && book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            return true;
        }
        return false;
    }

    // Return book
    public boolean returnBook(String bookId) {
        Book book = getBook(bookId);

        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            return true;
        }
        return false;
    }
}
