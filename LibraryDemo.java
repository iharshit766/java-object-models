import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}

// Library class
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// LibraryDemo class to demonstrate aggregation
public class LibraryDemo {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Creating libraries
        Library library1 = new Library();
        Library library2 = new Library();

        // Adding books to different libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book3);
        library2.addBook(book1); // Same book can be in multiple libraries

        // Display books in libraries
        System.out.println("Library 1 Books:");
        library1.displayBooks();

        System.out.println("\nLibrary 2 Books:");
        library2.displayBooks();
    }
}
