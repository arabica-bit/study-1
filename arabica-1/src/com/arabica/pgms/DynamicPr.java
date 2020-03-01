package com.arabica.pgms;

public class DynamicPr {


	public static void main(String[] args) {
		
		System.out.println("Dynamic Programming.");
		System.out.println("#----------------------#");
		DynamicPr dpr = new DynamicPr();
		
		//Params
		int N = 5;
		int number = 3;
		
		int result = dpr.solution(N, number);
		System.out.println("result: " + result);
	}

	/**
	 * 2020-03-01 프로그래머스 문제 풀이
	 * 동적계획법
	 * 
	 * 1) 작은 문제로 분할해서 계산하고, 이전에 계산한 것들을 저장해서 재사용 하는 개념.
	 * 2) 작은 문제를 어떻게 만들어야 할지 고민이 많았음. 규칙을 못찾아서...
	 * 3) F(K)의 규칙. K를 N을 몇번 사용하는지 지정한 횟수로 하고, F는 경우의 수의 합게.
	 * 		F(K) = F(1, K-1) + F(2, K-2) + F(3, K-3) + ... + F(K-1, 1) + K번연속붙인N
	 * 
	 * @param N
	 * @param number
	 * @return
	 */
	public int solution(int N, int number) {
        int answer = 0;
        return answer;
    }

	
}
