package com.arabica.pgms;

import java.util.HashMap;
import java.util.Map;

public class Hash2 {

	public static void main(String[] args) {
		
		System.out.println("---start---");
		Hash2 sol = new Hash2();
		
		//Params
		String[] phone_book = new String[] {"119", "97674223", "1195524421"};
		
		boolean result = sol.solution(phone_book);
		System.out.println("*result: " + result);
	}
	
	/**
	 * 2020-03-15 프로그래머스 문제 풀이
	 * 해시
	 * 1) 첫글자 기준으로 맵을 한번 분할하여 시간을 절약.
	 * 2) 굳이 두 파트로 나눌 필요는 없지만 나중에 봤을때 이해하기 편하다.
	 * 
	 * @date 2020-03-15 완료.
	 */
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<Integer, Map<String,Integer>> compMap = new HashMap<Integer, Map<String,Integer>>();
        //입력
        int arrLength = phone_book.length;
        for(int i=0; i<arrLength; i++) {
        	String phone = phone_book[i];
        	int head = Integer.parseInt(phone.substring(0,1));
        	if(compMap.containsKey(head)) {
        		Map<String,Integer> childMap = compMap.get(head);
        		childMap.put(phone, i); //배열의 인덱스를 넣음으로써 아래구문에서 동일한 값인지 구분할 수 있음.
        	}else {
        		Map<String, Integer> childMap = new HashMap<String, Integer>();
        		childMap.put(phone, i);
        		compMap.put(head, childMap);
        	}
        }
        
        //번호 찾기
        for(int i=0; i<arrLength; i++) {
        	String phone = phone_book[i];
        	int head = Integer.parseInt(phone.substring(0,1));
        	Map<String,Integer> childMap = compMap.get(head);
        	for(String childPhone: childMap.keySet()) {
        		if(childPhone.startsWith(phone) && !childMap.get(childPhone).equals(i)) {
        			//입력번호로 시작하고 && 인덱스가 다르면(입력번호가 아닌경우만)
        			return false;
        		}
        	}
        }
        
        
        return answer;
    }
}
