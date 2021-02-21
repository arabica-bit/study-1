package com.arabica.hkrank.day30;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 30 days of code
 * 8일차 : Dictionaries and Maps
 */
public class Day08_DicAndMap {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Map<String, Integer> phoneBook = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(phoneBook.containsKey(s)) System.out.println(s + "=" + phoneBook.get(s));
            else System.out.println("Not found");
        }
        in.close();
    }
}
