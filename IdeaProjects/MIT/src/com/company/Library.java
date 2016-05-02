package com.company;

import java.util.HashSet;
import java.util.*;

/**
 * Created by miku on 2016/05/02.
 */
public class Library {
    String name;
    HashMap<String, Book> books;

    public Library(String libraryName) {
        name = libraryName;
        books = new HashMap<String, Book>();
    }

    public void addBook(Book book){
        books.put(book.title,book);
    }

    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress(){
        System.out.println(name);
    }

    public void borrowBook(String bookName){
        if(books.containsKey(bookName)){
            Book book = books.get(bookName);
            if(book.isBorrowed()) {
                System.out.println("Sorry, this book is already borrowed.");
            }else{
                System.out.println("You successfully borrowed The Lord of the Rings");
                book.borrowed();
            }
        }else{
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void printAvailableBooks(){
        boolean containAvailableBook = false;
        Book book;
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            book = entry.getValue();
            if(!book.isBorrowed()) {
                System.out.println(book.title);
                containAvailableBook = true;
            }
        }
        if(!containAvailableBook){
            System.out.println("No book in catalog");
        }
    }

    public void returnBook(String bookName) {
        if (books.containsKey(bookName)) {
            Book book = books.get(bookName);
            if (book.isBorrowed()) {
                System.out.println("You successfully returned " + bookName);
                book.returned();
            } else {
                System.out.println("You did not borrow " + bookName);
            }
        } else {
            System.out.println("You did not borrow " + bookName + "in this library");
        }
    }


    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

       // Add four books to the first library
        //Book test = new Book("The Lord of the Rings");
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        //firstLibrary.addBook(test);

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();

    }
}
