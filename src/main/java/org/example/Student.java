package org.example;
import java.util.ArrayList;
public class Student extends Person{
    private String department;
    private ArrayList<Book> borrowedBooks;

    public Student(int id, String name, String department){
        super(id,name);
        this.department = department;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public void displayDetails(){
        System.out.println("----Student Details----");
        System.out.println("Student ID: "+getId());
        System.out.println("Student Name: "+getName());
        System.out.println("Student Department: "+department);
        System.out.println("Borrowed books: ");
        if(borrowedBooks.isEmpty()) System.out.print("No books borrowed");
        else{
            for(Book book:borrowedBooks){
                System.out.println("-> "+book.getBookName());
            }
        }
    }
}