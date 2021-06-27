package com.arabica.hkrank.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 30 days of code
 * 20일차 : 버블정렬
 * 버블정렬 구현 기초. (참고: https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html)
 */
public class Day20_Sorting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Write your code here
        Day20_Sorting solution = new Day20_Sorting();
        solution.bubbleSort(a,n);

        bufferedReader.close();
    }

    void bubbleSort(List<Integer> a, int n){
        int totalSwaps = 0;
        for(int i=0; i<n-1; i++){
            int swaps = 0;
            for(int j=0; j<n-1-i; j++){
                if(a.get(j) > a.get(j+1)) {
                    swap(a, j, j+1);
                    swaps++;
                }
            }
            totalSwaps += swaps;
            if(swaps == 0) break;
            else swaps=0;
        }

        System.out.println("Array is sorted in "+ totalSwaps +" swaps.");
        System.out.println("First Element: "+ a.get(0));
        System.out.println("Last Element: "+ a.get(n-1));
    }

    void swap(List<Integer> list, int n1, int n2){
        int temp = list.get(n1);
        list.set(n1, list.get(n2));
        list.set(n2, temp);
    }

}
