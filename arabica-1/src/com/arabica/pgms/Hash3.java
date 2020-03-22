package com.arabica.pgms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hash3 {

	public static void main(String[] args) {
		
		System.out.println("---start---");
		Hash3 sol = new Hash3();
		
		//Params
		String[][] param = new String[][] {{"yellow_hat", "headgear"}, 
			{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] param2 = new String[][] {{"crow_mask", "face"}, 
			{"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int result = sol.solution(param2);
		System.out.println("*result: " + result);
	}

	/**
	 * 2020-03-22 프로그래머스 문제 풀이
	 * 해시
	 * 1) 옷의 종류를 key로 하고, 옷의 개수를 정리함
	 * 2) 옷의 개수를 모두 곱해서 조합의 수를 구함. 단, 아무것도 안입는 조건 하나만 제외.
	 * 3) 생각보다 쉬워서 다행이다.
	 * 
	 * @date 2020-03-22 완료.
	 */
	 public int solution(String[][] clothes) {
	        int answer = 1;
	        
	        Map<String, Integer> wear = new HashMap<String, Integer>();
	        //입력 (옷의 종류별로 개수를 정리함)
	        for(String[] part: clothes) {
	        	if(wear.containsKey(part[1])) {
	        		wear.put(part[1], wear.get(part[1])+1);
	        	}else {
	        		wear.put(part[1], 2); //아무것도 안입는 null 경우 포함
	        	}
	        }
	        
	        Iterator<String> keys = wear.keySet().iterator();
	        while(keys.hasNext()) {
	        	Integer cases = wear.get(keys.next());
	        	answer = answer * cases;
	        }
	        
	        return answer-1; //모두 0인 경우 제외하고.
	    }

}
