import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add User");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = 0;

            // Handle input mismatch exception for the menu option
            while (true) {
                try {
                    option = scanner.nextInt();
                    break; // exit loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    scanner.next(); // clear the invalid input
                }
            }

            switch (option) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.next();
                    System.out.print("Enter User Name: ");
                    String userName = scanner.next();
                    System.out.print("Enter User Role (admin/librarian/member): ");
                    String userRole = scanner.next();
                    library.addUser(new User(userId, userName, userRole));
                    System.out.println("User added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.next();
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.next();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.next();
                    library.addBook(new Book(bookId, bookTitle, bookAuthor));
                    System.out.println("Book added successfully!");
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    String borrowUserId = scanner.next();
                    System.out.print("Enter Book ID: ");
                    String borrowBookId = scanner.next();
                    if (library.borrowBook(borrowUserId, borrowBookId)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Failed to borrow book. It might be already borrowed or invalid details provided.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    String returnBookId = scanner.next();
                    if (library.returnBook(returnBookId)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Failed to return book. It might not be borrowed or invalid details provided.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

// Assuming the existence of these classes
class Library {
    // Implement the methods as required
    public void addUser(User user) { /* implementation */ }
    public void addBook(Book book) { /* implementation */ }
    public boolean borrowBook(String userId, String bookId) { /* implementation */ return true; }
    public boolean returnBook(String bookId) { /* implementation */ return true; }
}

class User {
    private String userId;
    private String userName;
    private String userRole;
    
    public User(String userId, String userName, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
    }
}

class Book {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;

    public Book(String bookId, String bookTitle, String bookAuthor) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }
}
