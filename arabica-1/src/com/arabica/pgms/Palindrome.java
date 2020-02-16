package com.arabica.pgms;

public class Palindrome {
	
	/**
	 * 기본적인 문자열 과제
	 * 주어진 조건 자체가 단순했다.
	 */
	public static void main(String[] args) {
		System.out.println("--TEST--");
		
		System.out.println("find palindrome");
		
		Palindrome pd = new Palindrome();
		pd.solution("abbbba");
	}
	
	public void solution(String input) {
		System.out.println("input: " + input);
		//주어진 문자열의 절반 길이까지 진행하면서, 문자를 검사.
		//앞, 뒤 인덱스에 해당하는 문자가 하나라도 다르면 그 자리에서 False 반환. 중간까지 에러없으면 True.
		int count = 0;
		StringBuilder sb = new StringBuilder();
		int j=input.length()-1;
		for(int i=0; i<input.length()/2; i++,j--) {
			if(input.charAt(i) == input.charAt(j)) {
				count++;
				sb.append(input.charAt(i));
			}else {
				break;
			}
		}
		
		System.out.println("Palindrome length: " + count);
		System.out.println("Sb: " + sb.toString());
	}

}
