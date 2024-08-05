package lms;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

   
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
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

        Library library = new Library(books);

        System.out.println("Searching for '1984' using linear search:");
        Book foundBook = library.linearSearchByTitle("1984");
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}

