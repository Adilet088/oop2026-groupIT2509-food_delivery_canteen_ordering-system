import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addNewBook();
                case 3 -> searchBooks();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        try {
            books.add(new Book(title, author, year));
            System.out.println("Book added!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchBooks() {
        System.out.print("Enter part of the title to search: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) System.out.println("No books found");
    }

    private void borrowBook() {
        System.out.print("Enter book id to borrow: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.markAsBorrowed();
                    System.out.println("You borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book is already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void returnBook() {
        System.out.print("Enter book id to return: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.markAsReturned();
                    System.out.println("You returned: " + book.getTitle());
                } else {
                    System.out.println("This book was not borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void deleteBook() {
        System.out.print("Enter book id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        new LibraryApp().run();
    }
}

