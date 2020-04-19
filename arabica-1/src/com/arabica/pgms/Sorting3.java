package com.arabica.pgms;

import java.util.Arrays;

public class Sorting3 {
	public static void main(String[] args) {
		System.out.println("---start---");
		Sorting3 sol = new Sorting3();
		
		//int[] param = new int[] {5,5,5,5,5};
		int[] param = new int[] {3,0,6,1,5};
		
		int result = sol.solution_sysout(param);
		System.out.println("  ");
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-04-19 프로그래머스 문제 풀이
	 * 정렬 (H-index)
	 * 
	 * 1) 정렬은 Arrays가 다 해주니 큰 어려움은 없다.
	 * 2) H-Index를 구하는 것 자체가 문제인것 같다.
	 * 3) 같은 인용 횟수가 있으니 모든 값을 다 살펴볼 수 밖에 없다. (다른 사람도 똑같음)
	 * 4) 0번 논문 기준으로 h-index를 계산. 다음 논문으로 이동하되 같은 인용 횟수이면 패스하고.
	 * 5) 인용 횟수가 다르면 다시 해당 논문 기준 h-index를 계산. 가장 큰 h-index를 answer에 저장함.
	 * 6) 문제가 바뀌어서 중복이 없다고 가정하면, 반복 횟수를 더 줄일 수 있다.
	 * 
	 * @date 2020-04-19 완료.
	 */
	public int solution(int[] citations) {
		int answer = 0;
        int hIdx = 0;
        
        //정렬
        Arrays.sort(citations);
        
        Integer value = citations[0];
        for(int pos=0; pos<citations.length; pos++) {        	        	
        	int right = citations.length-pos;
        	Integer temp = citations[pos];        
        	
        	boolean ep = temp.equals(value); //이전 값과 같은 값이면 패스
        	if(pos == 0 || !ep) {
        		value = temp;
        		//인용 횟수, 편수 비교해서 더 작은 수를 선택.
            	hIdx = value;
            	if(value >= right) hIdx = right;
            	
            	//지금 선정한 hIndex가 answer보다 크면 교체.
            	if(hIdx > answer) answer = hIdx;
        	}     
        	
        }
        
        return answer;
    }
	
	public int solution_sysout(int[] citations) {
        int answer = 0;
        int hIdx = 0;
        
        //정렬
        Arrays.sort(citations);
        
        System.out.println("citations -> ");
        for(int i=0; i<citations.length; i++) {
        	System.out.println(String.format("%s[%s]", i, citations[i]));
        }
        
        Integer value = citations[0];
        for(int pos=0; pos<citations.length; pos++) {
        	int right = citations.length-pos;
        	Integer temp = citations[pos];
        	
        	boolean ep = temp.equals(value); //같은 값이면 패스
        	if(pos == 0 || !ep) {
        		value = temp;
        		//인용 횟수, 편수 비교해서 더 작은 수를 선택.
            	hIdx = value;
            	if(value >= right) hIdx = right;
            	
            	//지금 선정한 hIndex가 answer보다 크면 교체.
            	if(hIdx > answer) answer = hIdx;
        	}
        	
//        	Integer temp = citations[pos];
//        	if(temp.equals(value)) continue;
        	
//        	value = temp;
        	
        	
        	//인용 횟수, 편수 비교해서 더 작은 수를 선택.
//        	hIdx = value;
//        	if(value >= right) hIdx = right;
        	
        	//지금 선정한 hIndex가 answer보다 크면 교체.
//        	if(hIdx > answer) answer = hIdx;
        	
        }
        
        return answer;
    }
	
	
}
