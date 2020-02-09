package com.arabica.main;

public class FibonacciTest {

	public static void main(String[] args) {
		System.out.println("--TEST--");
		
		FibonacciTest fb = new FibonacciTest();
		int input=6;
		System.out.println("input: fibo("+input+")");
		fb.solution(input);
//		System.out.println("result: " + fb.solution(input));
	}
	
	public void solution(int input) {
		
		System.out.println("Answer:");
		
		for(int i=0; i<=input; i++) {
			System.out.println(fibo(i));
		}
	}

	public int fibo(int n) {
		//재귀 방법을 적용함.
		//원리 자체는 n, n-1, n-2가 한칸씩 쉬프트하는 구조이며, 
		//이 원리를 재귀함수로 표현한 것이다.
		if(n<=1) 
			return n;
		else	
			return fibo(n-2)+fibo(n-1);
	}
	
}
