package lms;
import java.util.Arrays;
import java.util.Comparator;

public class LibraryBinary {
    private Book[] books;

    public LibraryBinary(Book[] books) {
        this.books = books;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "The Catcher in the Rye", "J.D. Salinger")
        };

        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        LibraryBinary library = new LibraryBinary(books);

        System.out.println("Searching for '1984' using binary search:");
        Book foundBook = library.binarySearchByTitle("1984");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}



