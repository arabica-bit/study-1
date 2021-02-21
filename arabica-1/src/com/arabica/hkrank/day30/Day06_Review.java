package com.arabica.hkrank.day30;

import java.util.Scanner;
/**
 * 30 days of code
 * 6일차 : String, Loop 리뷰
 */
public class Day06_Review {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] inputS = new String[T];
        for(int i=0; i<T; i++){
            inputS[i] = scanner.nextLine();
        }

        scanner.close();

        StringBuffer evenBuffer;
        StringBuffer oddBuffer;
        for(int i=0; i<T; i++){
            evenBuffer = new StringBuffer();
            oddBuffer = new StringBuffer();
            int sLength = inputS[i].length();
            for(int q=0; q<sLength; q++){
                if(q%2==0) evenBuffer.append(inputS[i].charAt(q));
                else oddBuffer.append(inputS[i].charAt(q));
            }
            System.out.println(evenBuffer.toString() + " " + oddBuffer.toString());
        }

    }
}
