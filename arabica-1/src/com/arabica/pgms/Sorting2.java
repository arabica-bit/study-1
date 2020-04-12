package com.arabica.pgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorting2 {

	public static void main(String[] args) {
		
		System.out.println("---start---");
		Sorting2 sol = new Sorting2();
		
		//Params
		//int[] param = new int[] {6,10,2,61,63,1090,8,23,29,69,65,24,22};
		//int[] param = new int[] {6,10,2};
		//int[] param = new int[] {3, 30, 34, 5, 9};
		int[] param = new int[] {0,0,0,0,0};
		
		String result = sol.solution_sysout(param);
		System.out.println("  ");
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-04-05 프로그래머스 문제 풀이
	 * 정렬
	 * 
	 * 1) 입력의 첫 한자리가 같은 숫자들끼리 ArrayList를 생성.
	 * 2) 첫 한자리가 9인 ArrayList부터 순서대로 출력하면 1단계 완료.
	 * 3) ArrayList 안에서 다시 정렬하여 토큰 단위 비교해서 정렬.
	 *  실패.. [0,0,0]인 케이스에서 '0'이 반환되어야 하는데 그런점도 미비했고.
	 * 특히 더 쉬운 접근법이 있는데 그걸 생각못했다... 새로 풀자.
	 * @date 2020-04-12 종료.
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
					// true일때 -1을 하면 내림차순으로 정렬 
					return compareToken(o1, o2)?-1:1;
				}        		
        	});
        }
       
        //가장 큰수 만들기
        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	for(String item: body) {
        		answer=answer.concat(item);
        	}
        }
        
        return answer;    
	}
		
	public String solution_sysout(int[] numbers) {
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
        
        System.out.println();
        List<Integer> headKey = new ArrayList<>(head.keySet());
        Collections.reverse(headKey); //내림차순으로 뒤집는다.
        //Head,Body 분리 결과 확인 
        for(Integer k: headKey) {
        	System.out.println(String.format("Key : %s, Value : %s", k, head.get(k)));	
        }
        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	body.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// true일때 -1을 하면 내림차순으로 정렬 
					return compareToken(o1, o2)?-1:1;
				}        		
        	});
        }

        //내부 정렬 결과 확인
        System.out.println("~");
        for(Integer k: headKey) {
        	System.out.println(String.format("Key : %s, Value : %s", k, head.get(k)));	
        }
        
        //가장 큰수 만들기
        for(Integer k: headKey) {
        	ArrayList<String> body = head.get(k);
        	for(String item: body) {
        		answer=answer.concat(item);
        	}
        }
        
//        System.out.println("compare [30] and [303030304] :" + compare("30", "303030304") );
//        System.out.println("~~~");
//        System.out.println("compare [32] and [3232323231] :" + compare("32", "3232323231") );
        
        return answer;
    }
	
	/* 
	 * 아래 getPriorityToken과 로직을 동일하다. 다만, 리턴할때, s1을 기준으로 함.
	 * 반환 값이 s1과 같으면 true, 다르면 false를 리턴함.
	 */
	public boolean compareToken(String s1, String s2) {
		String longS = s1;
		String shortS = s2;
		if(s2.length() >= s1.length()) {
			longS = s2;
			shortS = s1;
		}
		
		int times = longS.length()/shortS.length();		
		Integer shortInt = Integer.parseInt(shortS);
		for(int i=0; i<times; i++) {
			//short String 길이만큼 단위 비교해서 더 큰 토큰을 리턴. 같으면 다음 token으로 진행.
			int pos = i*shortS.length();
			String token = longS.substring(pos,(pos+shortS.length()));
			Integer longInt = Integer.parseInt(token);
			//System.out.println("token[" + token + "], longInt[" + longInt + "] and ShortInt["+shortInt+"]");
			if(longInt.compareTo(shortInt)>0) {
				return s1.equals(longS);
			}else if(longInt.compareTo(shortInt)<0) {
				return s1.equals(shortS);
			}			
		}
		
		//Long String의 자투리도 비교. (ex. 31과 314를 비교하면 4가 자투리로 남으니까..)
		int rem = longS.length()%shortS.length();
		if(rem != 0) {			
			String token = longS.substring((times*shortS.length()),longS.length());
			for(int i=0; i<rem; i++) {
				token = token.concat("0");
			}
			Integer longInt = Integer.parseInt(token);
			//System.out.println("rem["+ rem + "]");
			//System.out.println("tail[" + token + "], longInt[" + longInt + "] and ShortInt["+shortInt+"]");
			if(longInt.compareTo(shortInt)>0) {
				return s1.equals(longS);
			}else if(longInt.compareTo(shortInt)<0) {
				return s1.equals(shortS);
			}
		}
		
		//쪼개어 비교한 결과가 모두 같으면 길이가 짧은 쪽을 리턴.
		return s1.equals(shortS);
	}
		
	
	/*
	 * 두 String을 비교하여 더 큰 Token 반환.
	 * 더 큰수를 만들 수 있는 String을 찾는다. 
	 */
	public String getPriorityToken(String s1, String s2) {
		String longS = s1;
		String shortS = s2;
		if(s2.length() >= s1.length()) {
			longS = s2;
			shortS = s1;
		}
		
		int times = longS.length()/shortS.length();		
		Integer shortInt = Integer.parseInt(shortS);
		for(int i=0; i<times; i++) {
			//short String 길이만큼 단위 비교해서 더 큰 토큰을 리턴. 같으면 다음 token으로 진행.
			int pos = i*shortS.length();
			String token = longS.substring(pos,(pos+shortS.length()));
			Integer longInt = Integer.parseInt(token);
			System.out.println("token[" + token + "], longInt[" + longInt + "] and ShortInt["+shortInt+"]");
			if(longInt.compareTo(shortInt)>0) {
				return longS;
			}else if(longInt.compareTo(shortInt)<0) {
				return shortS;
			}			
		}
		
		//Long String의 자투리도 비교. (ex. 31과 314를 비교하면 4가 자투리로 남으니까..)
		int rem = longS.length()%shortS.length();
		if(rem != 0) {			
			String token = longS.substring((times*shortS.length()),longS.length());
			for(int i=0; i<rem; i++) {
				token = token.concat("0");
			}
			Integer longInt = Integer.parseInt(token);
			System.out.println("rem["+ rem + "]");
			System.out.println("tail[" + token + "], longInt[" + longInt + "] and ShortInt["+shortInt+"]");
			if(longInt.compareTo(shortInt)>0) {
				return longS;
			}else if(longInt.compareTo(shortInt)<0) {
				return shortS;
			}
		}
		
		//쪼개어 비교한 결과가 모두 같으면 길이가 짧은 쪽을 리턴.
		return shortS;
	}
}



