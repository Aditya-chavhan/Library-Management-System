package Projects;
import java.util.*;

class Book {
    String title;
    String author;
    boolean issued;

    Book(String t, String a) {
        title = t;
        author = a;
        issued = false;
    }

    public String toString() {
        if (issued == true) {
            return title + " by " + author + " [Issued]";
        } else {
            return title + " by " + author + " [Available]";
        }
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("LIBRARY");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addBook();
            }
            else if (choice == 2) {
                viewBooks();
            }
            else if (choice == 3) {
                issueBook();
            }
            else if (choice == 4) {
                returnBook();
            }
            else if (choice == 5) {
                System.out.println("Exiting...");
            }
            else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Add Book
    static void addBook() {
        System.out.print("Enter title: ");
        String t = sc.nextLine();

        System.out.print("Enter author: ");
        String a = sc.nextLine();

        Book b = new Book(t, a);
        list.add(b);

        System.out.println("Book added!");
    }

    // View Books
    static void viewBooks() {
        if (list.size() == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nBook List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // Issue Book
    static void issueBook() {
        System.out.print("Enter book title: ");
        String t = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i);

            if (b.title.equals(t)) {
                if (b.issued == false) {
                    b.issued = true;
                    System.out.println("Book issued!");
                    return;
                }
            }
        }

        System.out.println("Book not available!");
    }

    // Return Book
    static void returnBook() {
        System.out.print("Enter book title: ");
        String t = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            Book b = list.get(i);

            if (b.title.equals(t)) {
                if (b.issued == true) {
                    b.issued = false;
                    System.out.println("Book returned!");
                    return;
                }
            }
        }

        System.out.println("Book not found or not issued!");
    }
}