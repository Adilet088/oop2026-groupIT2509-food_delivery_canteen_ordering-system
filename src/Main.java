public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("All Quiet on the Western Front", "Erich Maria Remarque", 1929);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 1997);

        System.out.println(book1);
        System.out.println(book2);

        book1.markAsBorrowed();
        System.out.println(book1);

        book1.markAsReturned();
        System.out.println(book1);
    }
}