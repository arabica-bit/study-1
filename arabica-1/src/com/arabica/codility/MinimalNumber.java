package com.arabica.codility;

import java.util.Arrays;

public class MinimalNumber {
	

	public static void main(String[] args) {
		
		System.out.println("---start---");
		MinimalNumber sol = new MinimalNumber();
		
		int[] param1 = new int[] {2,1};
		int[] param2 = new int[] {3,3};
		int result = sol.solution(param1, param2);
		int result2 = sol.solution2(param1, param2);
		
		System.out.println("### result : " + result);
		System.out.println("### result2 : " + result2);
	}

	/**
	 * 2020-05-17  Codility 테스트 - 네이버파이낸셜
	 * (task이름은 컨닝의 우려인지 알려주지 않았음)
	 * 
	 * 1) 주어진 solution에서 잘못된걸 찾아서 solution2에서 편집.
	 * 2) 붙여넣기, 줄 추가는 불가능하고 오직 현재 코드에서 수정만 가능한 문제. 
	 * 
	 * @결과: 못풀었음.
	 */
	int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
	
	int solution2(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
        	for(int t = 0; t < m; t++) {
        	
                if (A[k] == B[i])
                    return A[k];
        	}
            
        }
        return -1;
    }
}



/**
*You are given an implementation of a function:
 class solution;

that, given a non-empty array A of N non-negative integers and a non-empty array B of M non-negative integers, returns the minimal value that occurs in both arrays. If there is no such value, the function should return −1.

For example, given arrays A and B such that:

your function should return 2, since 2 is the minimal value which occurs in both arrays A and B (another value which occurs in both arrays is 3).

Given arrays A and B such that:

your function should return −1, since there is no value that occurs in both arrays.

The attached code is still incorrect for some inputs. Despite the error(s), the code may produce a correct answer for the example test cases. The goal of the exercise is to find and fix the bug(s) in the implementation. You can modify at most two lines.
*/