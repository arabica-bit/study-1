package com.arabica.pgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorting2_1 {
	public static void main(String[] args) {
		System.out.println("---start---");
		Sorting2_1 sol = new Sorting2_1();
		
		//int[] param = new int[] {999,998,9, 0};
		int[] param = new int[] {0,0,0,0,0};
		
		String result = sol.solution_sysout(param);
		System.out.println("  ");
		System.out.println("result: " + result);
	}

	/**
	 * 2020-04-05 프로그래머스 문제 풀이
	 * 정렬 (가장 큰 수)
	 * 
	 * 1) 'Sorting2' 클래스에서 풀던 문제를 쉬운 접근법으로 새로 푼다.
	 * 2) 주어진 두 수 A,B에 대하여 (A+B)와 (B+A)중 더 큰 수를 선택하면 된다.
	 * 3) 마지막에 answer를 만들때 StringBuilder를 사용할 수도 있단 점 기억한다.
	 * 
	 * @date 2020-04-12 완료.
	 */
	public String solution(int[] numbers) {
		String answer = "";

		Map<Integer,ArrayList<String>> head = new HashMap<Integer, ArrayList<String>>();
        for(Integer num : numbers) {
        	String temp = num.toString().substring(0,1);
        	Integer first = Integer.parseInt(temp);
        	if(head.containsKey(first)) {
        		ArrayList<String> body = head.get(first);
        		body.add(num.toString());
        		
        	}else {
        		ArrayList<String> body = new ArrayList<String>();
        		body.add(num.toString());
        		head.put(first, body);
        	}
        }
        
        
        List<Integer> headKey = new ArrayList<>(head.keySet());
        Collections.reverse(headKey); //내림차순으로 뒤집는다.    
        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	body.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					Integer o1Start = Integer.parseInt(o1.concat(o2));
					Integer o2Start = Integer.parseInt(o2.concat(o1));
					return o1Start.compareTo(o2Start)*-1; //-1이면 내림차순
				}        		
        	});
        	
        }

        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	for(String item: body) {
        		answer=answer.concat(item);
        	}
        }
        
        //{0,0,0,0} 케이스 처리.
        if(answer.indexOf("0") == 0) answer="0";
				
		return answer;
	}
	
	private String solution_sysout(int[] numbers) {
		String answer = "";

		Map<Integer,ArrayList<String>> head = new HashMap<Integer, ArrayList<String>>();
        for(Integer num : numbers) {
        	String temp = num.toString().substring(0,1);
        	Integer first = Integer.parseInt(temp);
        	if(head.containsKey(first)) {
        		ArrayList<String> body = head.get(first);
        		body.add(num.toString());
        		
        	}else {
        		ArrayList<String> body = new ArrayList<String>();
        		body.add(num.toString());
        		head.put(first, body);
        	}
        }
        
        
        List<Integer> headKey = new ArrayList<>(head.keySet());
        Collections.reverse(headKey); //내림차순으로 뒤집는다.
        
        for(Integer k: headKey) {
        	System.out.println(String.format("Key : %s, Value : %s", k, head.get(k)));	
        }
        
        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	body.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					Integer o1Start = Integer.parseInt(o1.concat(o2));
					Integer o2Start = Integer.parseInt(o2.concat(o1));
					return o1Start.compareTo(o2Start)*-1; //-1이면 내림차순
				}        		
        	});
        	
        }
        
        System.out.println(" - -- - -- - -- -");
        for(Integer k: headKey) {
        	System.out.println(String.format("Key : %s, Value : %s", k, head.get(k)));	
        }
        
        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	for(String item: body) {
        		answer=answer.concat(item);
        	}
        }
        
        //{0,0,0,0} 케이스 처리.
        if(answer.indexOf("0") == 0) answer="0";
				
		return answer;
	}
}
