package com.arabica.hkrank.day30;

import java.util.Scanner;

/**
 * 30 days of code
 * 2일차 : 연산
 * scanner 사용시 주의할 점으로 언급했던, nextInt와 netxtDouble의 처리 방법을 확인할 수 있음.
 */
public class Day02_operators {

    // Complete the solve function below.
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        Double tipCost = meal_cost/100 * tip_percent;
        Double taxCost = meal_cost/100 * tax_percent;

        Double total_cost = meal_cost + tipCost + taxCost;
        Long rounded_cost = Math.round(total_cost);

        System.out.println(rounded_cost);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double meal_cost = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //Scanner에서 특정타입을 바로 변환입력 받을 때 발생하는 잔여 입력('\n')등을 스킵.

        int tip_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int tax_percent = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(meal_cost, tip_percent, tax_percent);

        scanner.close();
    }

}
