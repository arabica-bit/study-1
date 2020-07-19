package com.arabica.pgms.skilltest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillCheck01_a {
	
	public static void main(String[] args) {
		System.out.println("#----------------------#");
		SkillCheck01_a sol = new SkillCheck01_a();
		
		//Params
//		String[] strs = new String[] {"sun", "bed", "car"};
		String[] strs = new String[] {"abce", "abcd", "cdx"};
		int n = 2;
		
		
		String[] result = sol.solution(strs, n);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-07-19 프로그래머스 체크 문제 1/2
	 * 
	 * 0) 문제: 문자 배열이 주어진다. 여기서 각 문자열의 'n'번째 인덱스에 해당하는 문자를 뽑아서,
	 *    그 문자들의 오름차순으로 문자 배열을 정렬해야 한다.
	 * 0) 조건: *모든 문자열의 길이는 'n'의 값보다 크기 때문에 에러는 고려하지 않음.
	 *          *'n'번째 문자가 서로 동일한 경우, 두 문자열 전체의 오름차순으로 정렬한다.
	 *          *문자 배열은 1~50개로 이뤄진다.
	 *          
	 * 1) 해쉬맵을 이용하여 풀이. 각 문자열의 'n'번째 인덱스를 key로 할당.
	 * 2) 그리고 key에 해당하는 value는 문자리스트로 생성한다.
	 * 3) 문자리스트와 key를 Comparator를 이용하여 각각 오름차순 정렬하여 출력하면 끝.         
	 * 
	 * 
	 */
	public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> result = new ArrayList<String>();
        
        Map<String, ArrayList<String>> strMap = new HashMap<String, ArrayList<String>>();
        
        for(String s : strings) {
        	String key = s.substring(n,n+1);        
        	if(strMap.containsKey(key)) {
        		ArrayList<String> words = strMap.get(key);
        		words.add(s);
        	}else {        		
        		ArrayList<String> words = new ArrayList<String>();
        		words.add(s);
        		strMap.put(key, words);
        	}                    
        }
        
        //key 순서 정렬
        List<String> keyList = new ArrayList<>(strMap.keySet());
        keyList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
        });
        
        //Body 순서 정렬 및 결과 리스트 추가
        for(String k : keyList) {
        	if(strMap.get(k).size() > 1) {
        		ArrayList<String> body = strMap.get(k);
        		body.sort(new Comparator<String>() {
        			@Override
        			public int compare(String o1, String o2) {
        				// TODO Auto-generated method stub
        				return o1.compareTo(o2);
        			}
        		});
        		
        		for(String b : body) {
        			result.add(b);
        		}        		
        	}else {
        		ArrayList<String> body = strMap.get(k);
        		result.add(body.get(0));
        	}
        }
        
        answer = (String[]) result.toArray(new String[strings.length]);
        
        //test
        for(String a: answer) {
        	System.out.println(a);
        }
        
        return answer;
    }
}
