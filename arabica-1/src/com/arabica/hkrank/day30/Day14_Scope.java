package com.arabica.hkrank.day30;

import java.util.Scanner;
/**
 * 30 days of code
 * 14일차 : scope
 * 배열안에서 각 인자간의 값의 차이중에서 가장 큰 값을 탐색.
 */
public class Day14_Scope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

class Difference {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    public Difference(int[] a){
        this.elements = a;
    }

    void computeDifference(){
        int maxDiff = -1;
        for(int i=0; i<elements.length-1; i++){
            for(int q=i+1; q<elements.length-i; q++){
                int temp = Math.abs(elements[i]-elements[q]);
                if(maxDiff < temp) maxDiff = temp;
            }
        }
        maximumDifference = maxDiff;
    }

} // End of Difference class