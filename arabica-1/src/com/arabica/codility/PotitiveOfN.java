package com.arabica.codility;

import java.util.HashMap;
import java.util.Map;

public class PotitiveOfN {
	
	public static void main(String[] args) {
		
		System.out.println("---start---");
		PotitiveOfN sol = new PotitiveOfN();
		
		int[] param = new int[] {1,3,6,4,1,2};
		int result = sol.solution(param);
		
		System.out.println("### result : " + result);
	}
	
	/**
	 * 2020-05-17  Codility 데모 테스트
	 * MissingInteger
	 * 
	 * 1) N개의 정수로 이루어진 배열 A가 주어짐. A에서 나타나지 않은 가장 작은 양의 정수를 찾는 문제.
	 * 2) 문제 전문은 아래에 적었음.
	 * 3) 데모라서 크게 어렵지 않았다. 정확도,성능(모두0.5초이내) 통과...
	 * 
	 */
	public int solution(int[] A) {
        
		Map<Integer, Integer> posMap = new HashMap<Integer, Integer>();
		for(int i=0; i<A.length; i++) {
			if(A[i]>0) {
				posMap.put(A[i], 1);
			}
		}
		
		for(int q=1; q<1000000; q++) {
			if(!posMap.containsKey(q)) {
				return q;
			}
		}
		
		return 1;
    }

}

/**
 * This is a demo task.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].

Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited. 

*/