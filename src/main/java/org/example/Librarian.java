package org.example;

public class Librarian extends Person implements LibraryOperations {

    private Library library;

    public Librarian(int id, String name, Library library) {
        super(id, name);
        this.library = library;
    }

    public void addBook(Book book) {
        library.getBooks().add(book);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        for (Book book : library.getBooks()) {
            book.displayDetails();
            System.out.println();
        }
    }

    @Override
    public void issueBook(int studentId, int bookId) {

        Student student = library.findStudentById(studentId);
        Book book = library.findBookById(bookId);

        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book not available");
            return;
        }

        if (student.getBorrowedBooks().size() >= 3) {
            System.out.println("Student cannot issue more than 3 books at a time.");
            return;
        }

        student.borrowBook(book);
        book.markAsIssued();

        System.out.println("Book issued successfully");
    }

    @Override
    public void returnBook(int studentId, int bookId) {

        Student student = library.findStudentById(studentId);
        Book book = library.findBookById(bookId);

        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (!student.getBorrowedBooks().contains(book)) {
            System.out.println("Student did not borrow this book");
            return;
        }

        student.returnBook(book);
        book.markAsAvailable();

        System.out.println("Book returned successfully");
    }

    @Override
    public void displayDetails() {
        System.out.println("---- Librarian Details ----");
        System.out.println("Librarian ID: " + getId());
        System.out.println("Librarian Name: " + getName());
    }
}