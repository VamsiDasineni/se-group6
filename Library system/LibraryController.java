// LibraryController.java (Controller)
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryController {
    private List<Book> library;
    private LibraryView view;

    public LibraryController(LibraryView view) {
        this.library = new ArrayList<>();
        this.view = view;
    }

    public void addBook(Book book) {
        library.add(book);
        view.showMessage("Book added successfully!");
    }

    public void removeBook(String title) {
        List<Book> foundBooks = library.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        if (!foundBooks.isEmpty()) {
            library.removeAll(foundBooks);
            view.showMessage("Book removed successfully!");
        } else {
            view.showMessage("No book found with title: " + title);
        }
    }

    public void displayBooks() {
        view.printLibrary(library);
    }

    public void searchBooksByTitle(String title) {
        List<Book> foundBooks = library.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
        view.printLibrary(foundBooks);
    }

    public void executeUserChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                Book book = view.getBookDetails();
                addBook(book);
                break;
            case 2:
                String titleToRemove = view.getBookTitle();
                removeBook(titleToRemove);
                break;
            case 3:
                displayBooks();
                break;
            case 4:
                String titleToSearch = view.getBookTitle();
                searchBooksByTitle(titleToSearch);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                view.showMessage("Invalid choice. Please try again.");
                break;
        }
    }
}
