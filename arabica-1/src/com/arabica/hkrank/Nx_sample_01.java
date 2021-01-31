package com.arabica.hkrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 해커랭크 샘플 테스트
 * 01: FizzBuzz
 * 입력 숫자가 3 또는 5의 배수이면 특정한 문구를 출력하는 코드를 작성.
 *
 * 입력이 3과 5의 배수이면 : "FIZZBUZZ"
 * 3의 배수, 5는 아니면: "FIZZ"
 * 3은 아니고, 5의 배수: "BUZZ"
 * 어디에도 해당하지 않으면: "입력숫자"그대로.
 *
 * sample이라 의미없음....
 */
public class Nx_sample_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.fizzBuzz(n);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here
        for(int i=1; i<=n; i++){
            if(i % 3 == 0) {
                if(i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }else System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }

    }

}