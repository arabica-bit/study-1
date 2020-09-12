package com.arabica.pgms.skilltest;

public class SkillCheck01_b {

	public static void main(String[] args) {
		System.out.println("#----------------------#");
		SkillCheck01_b sol = new SkillCheck01_b();
		
		//Params
		String strs = "-1234";
		
		
		int result = sol.solution2(strs);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-07-19 프로그래머스 체크 문제 2/2
	 * 
	 * 0) 문제: 숫자와 부호로 이루어진 문자열이 주어지면 이를 숫자로 반환하는 함수 작성.
	 *    예) "1234"가 들어오면, int(1234)를 반환. 그리고 "-1234"가 들어오면 int(-1234)를 반환.
	 * 0) 조건: *부호는 없을 수도 있지만, 포함된다면 맨 앞에만 주어진다.
	 *          *문자 길이는 1~5.
	 *    
	 * 1) 사실 Integer.parseInt를 사용하면 되지만, 당연히 그런 문제는 아닐거지만.
	 *    풀이 제한시간이 얼마 없어서 그냥 Integer.parseInt(s)로 제출했더니 해결됨.
	 *    
	 * 2) 만약 문제 조건에 그런걸 쓰지 말라고 했다면 solution2처럼 하면 될것 같다.
	 * 3) 모든 문자열을 1개씩 쪼갠다.
	 * 4) 각 문자가 부호(-)와 각 숫자(0~9)에 해당하는지 스위치로 검사하여 더해준다.
	 * 5) 부호와 자릿수만 고려하면 될것 같다.
	 */
	public int solution(String s) {
        int answer = 0;
        answer = Integer.parseInt(s);
        return answer;
    }
	
	
	 public int solution2(String s) {
	        int answer = 0;
	        int sign = 1;
	        
	        String[] strs = s.split("");
	        for(String c : strs) {
	        	switch(c) {
	        	case "-":	//+기호는 있으나 없으나 처리할게 없으니 제외.
	        		sign *= -1;
	        		break;
	        	case "0":
	        		answer += 0;
	        		answer *= 10;
	        		break;
	        	case "1":
	        		answer += 1;
	        		answer *= 10;
	        		break;
	        	case "2":
	        		answer += 2;
	        		answer *= 10;
	        		break;
	        	case "3":
	        		answer += 3;
	        		answer *= 10;
	        		break;
	        	case "4":
	        		answer += 4;
	        		answer *= 10;
	        		break;
	        	case "5":
	        		answer += 5;
	        		answer *= 10;
	        		break;
	        	case "6":
	        		answer += 6;
	        		answer *= 10;
	        		break;
	        	case "7":
	        		answer += 7;
	        		answer *= 10;
	        		break;
	        	case "8":
	        		answer += 8;
	        		answer *= 10;
	        		break;
	        	case "9":
	        		answer += 9;
	        		answer *= 10;
	        		break;
	        		
	        	}
	        }
	        
	        answer = sign*answer/10; //마지막에 0이 하나 더 붙게되니까 10으로 한번 나눠준다.
	        return answer;
	 }
}
