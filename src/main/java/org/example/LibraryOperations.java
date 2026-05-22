package org.example;

public interface LibraryOperations {
    void issueBook(int studentId, int bookId);

    void returnBook(int studentId, int bookId);
}
