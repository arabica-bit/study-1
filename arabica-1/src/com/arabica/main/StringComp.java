package com.arabica.main;

public class StringComp {

	/**
	 * 주어진 문자열을 압축한다.
	 * 반복되는 문자는 해당문자+반복횟수로 표현한다.
	 * 제한: 1개이면 숫자 표기하지 않음.
	 */
	public static void main(String[] args) {
		System.out.println("--TEST--");
		
		StringComp sc = new StringComp();
		System.out.println("Result: " + sc.solution("abbbb"));
		System.out.println("Result: " + sc.solution("####$#$#$"));
		System.out.println("Result: " + sc.solution("dffdffd"));
		System.out.println("Result: " + sc.solution("qqqffaf"));
		System.out.println("Result: " + sc.solution("b"));
		System.out.println("Result: " + sc.solution("$$%%$$%%"));
		
	
	}
	
	public String solution(String input) {
		if(input.isEmpty()) return "-"; //빈문자열처리
		if(input.length()==1) return input; //길이가1인 문자열처리
		
		int count = 1;
		StringBuilder sb = new StringBuilder();
		char pointer = input.charAt(0);
		for(int i=1; i<input.length(); i++) {
			if(input.charAt(i) == pointer) {
				count++;
			}else {
				sb.append(pointer);
				if(count>1) sb.append(count);
				pointer = input.charAt(i);
				count=1;
			}
			
			//마지막 부분 처리
			if(i>=input.length()-1) {
				sb.append(pointer);
				if(count>1) sb.append(count);
			}
		}
		
		return sb.toString();

	}
}
