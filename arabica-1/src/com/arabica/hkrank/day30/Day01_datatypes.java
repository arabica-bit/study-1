package com.arabica.hkrank.day30;

import java.util.Scanner;

/**
 * 30 days of code
 * 1일차 : 데이터 타입
 * scanner 사용시 주의할 점: nextInt()와 같이 타입을 지정해서 받는 메소드는 'Enter'(\n)값을 무시하고 해당 타입만 받아 변환하여 반환하는데
   이때 컴퓨터 내부에서는 'Enter' 입력이 아직 남아있기 때문에 nextLine()에서 '\n'을 받아들이고 그대로 입력되어 종료!
 */
public class Day01_datatypes {
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        //scan.nextInt(); -> 숫자가 아닌 문자열을 추가로 입력받아야할 상황에선 원하는대로 동작하지 않음.
        Integer first;
        first= Integer.parseInt(scan.nextLine());
        Double second;
        second= Double.parseDouble(scan.nextLine());
        String third;
        third= scan.nextLine();

        System.out.println(i+first);
        System.out.println(String.format("%.1f", d+second));
        System.out.println(s+third);


        scan.close();

    }
}
