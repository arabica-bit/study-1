package com.arabica.hkrank;
import java.io.*;
import java.util.*;

/**
 * Practice -> Interview Preparation Kit
 * Warm-up Challenges 04: Repeated String
 *
 * 반복되는 문자열에서 인덱스 0~n 사이에 알파벳 'a'가 몇개인지 찾는 문제.
 * 주어진 변수 n의 길이를 만족할 만큼 문자열 s는 계속 반복된다.
 *
 * 입력 케이스 [a, 10000000] 같은 1개짜리 s 입력만 주의하면 특별한 이슈는 없음.
 */
public class Interview_04 {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int unitCnt = 0;
        for(char c:s.toCharArray()){
            if(c == 'a') unitCnt++;
        }

        long base = n/s.length();
        long aCnt = unitCnt * base;

        long baseRem = n%s.length();
        for(int i=0; i<baseRem; i++){
            if(s.charAt(i) == 'a') aCnt++;
        }
        System.out.println(aCnt);
        return aCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sjtest.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
