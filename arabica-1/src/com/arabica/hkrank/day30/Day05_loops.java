package com.arabica.hkrank.day30;

import java.util.Scanner;

/**
 * 30 days of code
 * 5일차 : 반복문..
 */
public class Day05_loops {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();


        for(int i=1; i<=10; i++){
            System.out.println(n + " x " + i + " = " + (i*n));
        }
    }
}
