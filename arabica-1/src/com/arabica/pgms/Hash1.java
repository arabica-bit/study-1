package com.arabica.pgms;

import java.util.HashMap;
import java.util.Map;

public class Hash1 {
	

	/**
	 * 프로그래머스 문제 풀이
	 * 예전에 풀었던 문제 정리.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Hash algorithm 1.");
		Hash1 hs = new Hash1();
		
		//Params
		String[] participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = new String[] {"josipa", "filipa", "marina", "nikola"};
		
		String result = hs.solution(participant, completion);
		System.out.println("result: " + result);
		
	}
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> compMap = new HashMap<String,Integer>();
        //완주자 명단
		for(String name: completion){
			if(compMap.containsKey(name)){
				compMap.replace(name, (Integer)compMap.get(name)+1);
			}else {
				compMap.put(name, 0);
			}
		}

		//참가자 찾기
		for(String person: participant){
			if(compMap.containsKey(person)){
				if((Integer)compMap.get(person)!=0){
					compMap.replace(person, (Integer)compMap.get(person)-1);
				}else{
					compMap.remove(person);
				}
			}else{
				answer=person;
				return answer;
			}
		}
        
        return answer;
    }

}
