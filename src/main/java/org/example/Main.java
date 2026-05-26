package org.example;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Library library=new Library();
        Librarian librarian = new Librarian(1,"Admin",library);
        while(true){
            System.out.println("-----Library Management System-----");
            System.out.println("Enter your choice: \n1.Add book \n2.View Book \n3.Add Student \n4.Issue Book \n5.Return Book \n6.View Student Details \n7.Exit");
            int choice=-1;
            try{
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter valid choice");
            }
            switch(choice){
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter book name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorName = sc.nextLine();
                    Book book = new Book(bookId, bookName, authorName);
                    librarian.addBook(book);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    librarian.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int studentId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();
                    Student student = new Student(studentId, studentName, department);
                    library.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int issueStudentId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Book ID: ");
                    int issueBookId = Integer.parseInt(sc.nextLine());
                    librarian.issueBook(issueStudentId, issueBookId);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int returnStudentId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Book ID: ");
                    int returnBookId = Integer.parseInt(sc.nextLine());
                    librarian.returnBook(returnStudentId, returnBookId);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    int viewStudentId = Integer.parseInt(sc.nextLine());
                    Student s = library.findStudentById(viewStudentId);
                    if (s == null) {
                        System.out.println("Student not found.");
                    } else {
                        s.displayDetails();
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using Library Management System!!!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}