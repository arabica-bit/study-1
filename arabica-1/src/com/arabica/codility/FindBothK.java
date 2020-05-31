package com.arabica.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindBothK {


	public static void main(String[] args) {
		
		System.out.println("---start---");
		FindBothK sol = new FindBothK();
		
		int[] param = new int[] {-99999999,-9,9};
		int result = sol.solution(param);
		
		System.out.println("### result : " + result);
	}
	
	/**
	 * 2020-05-17  Codility 테스트 - 네이버파이낸셜
	 * (task이름은 컨닝의 우려인지 알려주지 않았음)
	 * 
	 * 1) 주어진 배열에서 -K와 K가 동시에 존재하는 양수중에서 가장 작은 K를 찾아서 반환.
	 * 2) Arrays.sort를 해도 HashMap의 key에서 정렬이 풀어질 수 있음. (음수 대신 절대값을 이용하는 것 같다.)
	 * 3) 배열을 HashMap에 넣을 때, 인덱스를 넣는지 값을 넣는지 헷갈리지 말자.
	 * 
	 * @결과: 정확도100%, 성능(100%)
	 */
	public int solution(int[] A) {
		
		Arrays.sort(A);
		Map<Integer,Integer> aMap = new HashMap<Integer,Integer>();
		for(int i=0; i<A.length; i++) {
			System.out.println("put : " + A[i]);
			aMap.put(A[i], 1);
		}
		
		for(Integer n: A) {
			System.out.println("keyset n: " + n);
			if(n!=0 && aMap.containsKey(n*(-1))) {
				if(n<0) return n*(-1);
				return n;
			}
		}
		
		return 0;
    }
}


/**
*Write solution that, given an array A of N integers, returns the largest integer K > 0 such that both values K and −K (the opposite number) exist in array A. If there is no such integer, the function should return 0.

Examples:

1. Given A = [3, 2, −2, 5, −3], the function should return 3 (both 3 and −3 exist in array A).

 2. Given A = [1, 1, 2, −1, 2, −1], the function should return 1 (both 1 and −1 exist in array A).

 3. Given A = [1, 2, 3, −4], the function should return 0 (there is no such K for which both values K and −K exist in array A).
* N is an integer within the range [1...100,000].
* each element of array A is an integer within the range [-1,000,000,000 ~ 1,000,000,000].

*/