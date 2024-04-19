// Main.java
public class Main {
    public static void main(String[] args) {
        LibraryView view = new LibraryView();
        LibraryController controller = new LibraryController(view);

        while (true) {
            int choice = view.printMenuAndGetSelection();
            controller.executeUserChoice(choice);
        }
    }
}
