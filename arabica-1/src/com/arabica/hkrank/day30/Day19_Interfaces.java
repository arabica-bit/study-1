package com.arabica.hkrank.day30;

import java.util.*;

/**
 * 30 days of code
 * 19일차: Interfaces
 * 나눗셈이 포함된 코드는 항상 0으로 나누는 동작이 발생하는지 생각해야 함..
 */
public class Day19_Interfaces{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0) sum+=i;
        }
        return sum;
    }
}

interface AdvancedArithmetic{
    int divisorSum(int n);
}