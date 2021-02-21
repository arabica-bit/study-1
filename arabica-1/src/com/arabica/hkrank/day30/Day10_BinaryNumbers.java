package com.arabica.hkrank.day30;

import java.util.Scanner;
/**
 * 30 days of code
 * 10일차 : 이진수
 */
public class Day10_BinaryNumbers {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        String binaryStr = Integer.toBinaryString(n);

        int max = 0;
        int temp = 0;
        for(char bs : binaryStr.toCharArray()){
            if(bs=='1') {
                temp++;
                if(temp>max) max=temp;
            }else {
                temp=0;
            }
        }
        System.out.println(max);
    }
}
