package LabProblems;
class Book {
    private String bookId, title, author;
    private boolean isAvailable = true;
    private static int totalBooks = 0;

    public Book(String t, String a) {
        totalBooks++;
        this.bookId = "B" + totalBooks;
        this.title = t;
        this.author = a;
    }

    public void issueBook() { if (isAvailable) isAvailable = false; }
    public void returnBook() { isAvailable = true; }
    public boolean getStatus() { return isAvailable; }
    public String getBookId() { return bookId; }

    public void display() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + (isAvailable ? "Available" : "Issued"));
    }
}

class Member {
    private String memberId, name;
    private String[] booksIssued = new String[3];
    private int bookCount = 0;
    private static int totalMembers = 0;

    public Member(String n) {
        totalMembers++;
        this.memberId = "M" + totalMembers;
        this.name = n;
    }

    public void borrowBook(Book b) {
        if (b.getStatus() && bookCount < 3) {
            b.issueBook();
            booksIssued[bookCount++] = b.getBookId();
            System.out.println(name + " borrowed " + b.getBookId());
        }
    }

    public void returnBook(String id, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(id)) {
                for (Book b : books) if (b.getBookId().equals(id)) b.returnBook();
                System.out.println(name + " returned " + id);
                booksIssued[i] = booksIssued[--bookCount];
                break;
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = { new Book("Java", "James"), new Book("C++", "Bjarne") };
        Member m1 = new Member("Alice");

        m1.borrowBook(books[0]);
        books[0].display();
        m1.returnBook("B1", books);
        books[0].display();
    }
}
