package com.arabica.hkrank.day30;

import java.util.Scanner;
/**
 * 30 days of code
 * 12일차 : 상속
 * 기존에 작성된 Person Class, Task를 참고하여 Student Class를 작성한다.
 * 동일패키지안에 Person class가 존재하여, Person_b로 이름 변경한 점 참고.
 */
public class Day12_Inheritance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}

class Person_b {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person_b(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }

}

class Student extends Person_b{
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here
    Student(String firstName, String lastName, int id, int[] scores){
        super(firstName, lastName, id);
        this.testScores = scores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
    public char calculate(){
        int total = 0;
        for(int score: testScores){
            total+=score;
        }
        int avg = total/testScores.length;
        if(90 <= avg && avg <= 100) return "O".charAt(0);
        else if(80 <= avg && avg < 90) return "E".charAt(0);
        else if(70 <= avg && avg < 80) return "A".charAt(0);
        else if(55 <= avg && avg < 70) return "P".charAt(0);
        else if(40 <= avg && avg < 55) return "D".charAt(0);

        return "T".charAt(0);
    }
}