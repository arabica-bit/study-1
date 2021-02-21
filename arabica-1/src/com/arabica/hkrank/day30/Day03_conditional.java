package com.arabica.hkrank.day30;

import java.util.Scanner;

/**
 * 30 days of code 
 * 3일차 : 조건문 소개
 * 특별히 걸리는 이슈 없었음.
 */
public class Day03_conditional {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        String w = "Weird";
        String nw = "Not Weird";
        if(N%2!=0){
            System.out.println(w);
        }else if(N <= 5){
            System.out.println(nw);
        }else if(N <=20){
            System.out.println(w);
        }else{
            System.out.println(nw);
        }
    }
}
