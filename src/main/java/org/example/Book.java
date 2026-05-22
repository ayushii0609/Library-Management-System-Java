package org.example;
public class Book{
    private int bookId;
    private String bookName;
    private String authorName;
    private boolean available;

    public Book(int bookId, String bookName, String authorName){
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        available = true;
    }

    public void displayDetails(){
        System.out.println("Book ID: "+getBookId());
        System.out.println("Book Name: "+getBookName());
        System.out.println("Author Name: "+getAuthorName());
        System.out.println("Availability status: "+((isAvailable())?"Available":"Issued"));
    }

    public int getBookId(){
        return bookId;
    }
    public String getBookName(){
        return bookName;
    }
    public String getAuthorName(){
        return authorName;
    }
    public boolean isAvailable(){
        return available;
    }

    public void markAsIssued(){
        available = false;
    }
    public void markAsAvailable(){
        available=true;
    }

}