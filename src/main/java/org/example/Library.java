package org.example;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) return book;
        }
        return null;
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) return student;
        }
        return null;
    }
}