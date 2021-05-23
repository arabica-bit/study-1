package com.arabica.hkrank.day30;

import java.util.Scanner;

/**
 * 30 days of code
 * 13일차 : 추상클래스 상속
 * 상속받은 메소드 "display()"를 다시 재정의할 때, private를 사용하면 안됨.
 * public 혹은 package-private를 사용한다. 아무것도 선언하지 않으면 후자임.
 */
public class Day13_Abstract {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
// Declare your class here. Do not use the 'public' access modifier.
// Declare the price instance variable
class MyBook extends Book{
    int price;
    /**
     *   Class Constructor
     *
     *   @param title The book's title.
     *   @param author The book's author.
     *   @param price The book's price.
     **/
    // Write your constructor here
    public MyBook(String title, String author, int price){
        super(title, author);
        this.price = price;
    }

    /**
     *   Method Name: display
     *
     *   Print the title, author, and price in the specified format.
     **/
    // Write your method here
    void display(){
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
    }
}
// End class

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}


