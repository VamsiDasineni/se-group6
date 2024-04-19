// LibraryView.java (View)
import java.util.List;
import java.util.Scanner;

public class LibraryView {
    private Scanner scanner = new Scanner(System.in);

    public void printBookDetails(Book book) {
        System.out.println("Book Details: ");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Year: " + book.getYear());
    }

    public void printLibrary(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                printBookDetails(book);
            }
        }
    }

    public int printMenuAndGetSelection() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Display All Books");
        System.out.println("4. Search Books by Title");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public Book getBookDetails() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        return new Book(title, author, year);
    }

    public String getBookTitle() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter the title to search or remove: ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
