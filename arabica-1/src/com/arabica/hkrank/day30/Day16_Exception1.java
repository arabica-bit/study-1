package com.arabica.hkrank.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 30 days of code
 * 16일차: Exceptions - String to Integer
 * 예외처리하기.
 */
public class Day16_Exception1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        bufferedReader.close();

        try{
            Integer a = Integer.parseInt(S);
            System.out.println(a);
        }catch (Exception e){
            System.out.println("Bad String");
        }
    }
}
