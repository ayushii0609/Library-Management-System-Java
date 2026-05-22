package org.example;
import java.util.ArrayList;
public class Library implements LibraryOperations{
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library(){
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void viewBooks(){
        for(Book book:books){
            book.displayDetails();
            System.out.println();
        }
    }

    public Book findBookById(int bookId){
        for(Book book:books){
            if(book.getBookId()==bookId) return book;
        }
        return null;
    }

    public Student findStudentById(int studentId){
        for(Student student : students){
            if(student.getId() == studentId) return student;
        }
        return null;
    }

    @Override
    public void issueBook(int studentId,int bookId){
        Student student = findStudentById(studentId);
        Book book=findBookById(bookId);

        if(student==null){
            System.out.println("Student not found");
            return;
        }

        if(book==null){
            System.out.println("Book not found");
            return;
        }
        if(!book.isAvailable()){
            System.out.println("Book not available!!");
            return;
        }
        if(student.getBorrowedBooks().size()>=3){
            System.out.println("Student cannot issue more than 3 books at a time.");
            return;
        }

        student.borrowBook(book);
        book.markAsIssued();
        System.out.println("Book issued successfully");
    }

    @Override
    public void returnBook(int studentId,int bookId){
        Student student = findStudentById(studentId);
        Book book=findBookById(bookId);

        if(student==null){
            System.out.println("Student not found");
            return;
        }

        if(book==null){
            System.out.println("Book not found");
            return;
        }
        if(!student.getBorrowedBooks().contains(book)){
            System.out.println("Student did not borrow this book");
            return;
        }

        student.returnBook(book);
        book.markAsAvailable();
        System.out.println("Book returned successfully");
    }

}