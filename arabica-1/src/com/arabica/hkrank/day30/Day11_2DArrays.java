package com.arabica.hkrank.day30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 30 days of code
 * 11일차 : 2차원배열..
 * 제한된 크기의 2차원배열에서 I형태의 3x3 배열의 합계를 계산하는 과정.
 */
public class Day11_2DArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        //solution
        int maxSum = -999;   //0 1 2 3 4 5
        for(int col=0; col<arr.size()-2; col++){
            for(int row=0; row<arr.get(col).size()-2; row++){
                int tempSum = arr.get(col).get(row);
                tempSum+= arr.get(col).get(row+1);
                tempSum+= arr.get(col).get(row+2);
                tempSum+= arr.get(col+1).get(row+1);
                tempSum+= arr.get(col+2).get(row);
                tempSum+= arr.get(col+2).get(row+1);
                tempSum+= arr.get(col+2).get(row+2);
                System.out.println("tempSum["+tempSum+"], current["+maxSum+"]");
                if(tempSum>maxSum) maxSum=tempSum;
            }
        }

        System.out.println(maxSum);
    }
}

