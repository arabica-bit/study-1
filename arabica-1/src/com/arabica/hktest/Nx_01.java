package com.arabica.hktest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 주어진 필터Range를 통과할 수 있는 Frequency의 개수를 찾는 문제
 * compareTo를 이용하여 푸는 상대적으로 쉬운 문제였다.
 */
public class Nx_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sjtest.txt"));

        int frequenciesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> frequencies = IntStream.range(0, frequenciesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int filterRangesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int filterRangesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> filterRanges = new ArrayList<>();

        IntStream.range(0, filterRangesRows).forEach(i -> {
            try {
                filterRanges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result_Nx_01.countSignals(frequencies, filterRanges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result_Nx_01 {

    /*
     * Complete the 'countSignals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY frequencies
     *  2. 2D_INTEGER_ARRAY filterRanges
     */

    public static int countSignals(List<Integer> frequencies, List<List<Integer>> filterRanges) {
        // Write your code here
        int cnt = 0;
        Integer Max_of_Lower = -1;
        Integer Min_of_Upper = 2000000000;

        //가장 좁은 filter Range를 구한다.
        for(List<Integer> filter : filterRanges){
            Integer lower = filter.get(0);
            Integer upper = filter.get(1);
            if(lower.compareTo(Max_of_Lower) > 0) Max_of_Lower = lower;
            if(upper.compareTo(Min_of_Upper) < 0) Min_of_Upper = upper;
        }

        //주어진 신호세기 검사
        for(Integer freq : frequencies){
            if(freq.compareTo(Max_of_Lower) >= 0 && freq.compareTo(Min_of_Upper) <= 0) cnt++;
        }

        System.out.println(cnt);
        return cnt;
    }

}