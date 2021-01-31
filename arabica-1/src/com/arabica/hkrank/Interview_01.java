package com.arabica.hkrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Practice -> Interview Preparation Kit
 * Warm-up Challenges 01: Sales by Match
 * 
 * 주어진 양말 배열에서 색상이 같은 페어가 몇개가 나오는지 계산.
 *
 * 주의할 점: 배열을 사용할 때는 항상 크기와 인덱스의 마지막 값을 잘 생각해야 한다. 인덱스가 100이면, 크기는 101로 생성해줘야 한다.
 * 컬러가 100개로 한정되어 있으므로, 실행시간은 고려하지 않아도 됨.
 */
public class Interview_01 {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int[] pairs = new int[101];

        for(int color : ar){
            pairs[color] +=1;
        }

        int result = 0;
        for(int after : pairs){
            int temp = after/2;
            result += temp;
        }

        System.out.println(result);
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sjtest.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
