package com.arabica.pgms;

import java.util.HashMap;
import java.util.Map;

public class Greedy {

	public static void main(String[] args) {
		
		System.out.println("Greedy algorithm.");
		Greedy gd = new Greedy();
		
		//Params
		int n=9;
		int[] lost = new int[] {2,4,7,8};
		int[] reserve = new int[] {3,6,9};
		
		int result = gd.solution(n, lost, reserve);
		System.out.println("result: " + result);
		
	}
	
	/**
	 * 2020-02-09 프로그래머스 문제 풀이
	 * 탐욕법 구현
	 * 
	 * 1) lost를 기준으로 체육복을 빌릴 수 있는지 여부를 찾아보는 방법으로 구현함.
	 * 2) Map에서 한 아이템을 remove했을 때, 다른 아이템의 index에는 영향을 주지 않는다는 점을 기억할 것. (헷갈려서 테스트코드 많이 넣었음)
	 * 3) 배열의 index가 헷갈려서 Index Exception이 나서 테스트케이스 하나 실패했었음.
	 * @date 2020-02-09 완료.
	 */
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        Map<Integer,Integer> rsvMap = new HashMap<Integer,Integer>();     
        for(int i=0; i<reserve.length; i++) {        	     
        	rsvMap.put(reserve[i], 1);
        }
        
        for(int j=0; j<lost.length; j++) {
        	int t = lost[j];
        	if(rsvMap.containsKey(t)) {
        		answer++;
        		rsvMap.remove(t);
        		continue;
        	}
        	if(rsvMap.containsKey(t-1)) {
        		answer++;
        		rsvMap.remove(t-1);
        		continue;
        	}
        	if(rsvMap.containsKey(t+1)) {
        		if(j<(lost.length-1) && lost[j+1]==(t+1)) {
        			continue;
        		}
        		answer++;
        		rsvMap.remove(t+1);
        		continue;
        	}
        }
        
        return answer;
    }
	
	public void showList(Map<Integer,Integer> input) {
		System.out.println("----------------------------------------------------");
		for(Integer q:input.keySet()) {
			System.out.println("key["+q+"], value["+input.get(q) + "].");
		}
	}
	
	//디버깅용 주석많이들어간거
	public int solutionWithComment(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        Map<Integer,Integer> rsvMap = new HashMap<Integer,Integer>();     
        for(int i=0; i<reserve.length; i++) {        	     
        	rsvMap.put(reserve[i], 1);
        }
        showList(rsvMap);
        System.out.println(" ");
        for(int j=0; j<lost.length; j++) {
        	int t = lost[j];
        	System.out.println("## t: " + t + " ##");
        	if(rsvMap.containsKey(t)) {	//잃어버린 스스로에게 여벌이 있는지
        		System.out.println("Pick from (t)");
        		showList(rsvMap);
        		answer++;
        		rsvMap.remove(t);
        		showList(rsvMap);
        		continue;
        	}
        	if(rsvMap.containsKey(t-1)) {	//왼쪽 사람이 여벌이 있는지 
        		showList(rsvMap);
        		System.out.println("Pick from (t-1)");
        		answer++;
        		rsvMap.remove(t-1);
        		showList(rsvMap);
        		continue;
        	}
        	if(rsvMap.containsKey(t+1)) {	//오른쪽 사람에게 여벌이 있는지
        		if(j<(lost.length-1) && lost[j+1]==(t+1)) {
        			continue;
        		}
        		System.out.println("Pick from (t+1)");
        		showList(rsvMap);
        		answer++;
        		rsvMap.remove(t+1);
        		showList(rsvMap);
        		continue;
        	}
        	
        }
        
        return answer;
    }
}
