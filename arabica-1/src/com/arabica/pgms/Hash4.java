package com.arabica.pgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hash4 {
	


	public static void main(String[] args) {
			
			System.out.println("---start---");
			Hash4 sol = new Hash4();
			
			//Params
			String[] param = new String[] {"a", "b", "a", "b", "c"};
			int[] param2 = new int[] {100, 200, 300, 400, 500};
			
			int[] result = sol.solution_sysout(param, param2);
			System.out.println("  ");
			System.out.println("*answer: " + result.length);
			for(int i=0; i<result.length; i++) {
				System.out.print(String.format(" %d[%d]", i, result[i]));
			}
			
	}
			
	/**
	 * 2020-03-22 프로그래머스 문제 풀이
	 * 해시 풀이
	 * 
	 * 1) HashMap을 여러개 이용해서 재생 총합 별도로 정리하고,
	 * 2) 각 장르끼리 재생횟수도 별도로 정리하여 풀이함.
	 * 3) value로 정렬해야 해서, 결국 Collections.sort를 대략 이해할 수 있었다.
	 * 4) Total의 정렬 결과를 갖고, 각 plays 배열 항목을 뽑아야 하는데.. 정렬만 하고 그 결과(gTotal)를 안쓰고..
	 *    정렬안된 맵인 playMap만 갖고 result를 뽑는 실수를 해서.. 일주일 더 걸림.
	 * 5) 하여튼 hashmap은 key는 자동 정렬. value는 collection을 이용해 정렬하되 키값이 정렬되는거니까 잘 생각하고 쓸것.
	 * @date 2020-04-05 완료.
	 */
	 public int[] solution(String[] genres, int[] plays) {		 
		 //수록 제한
		 int limit = 2;
		 		 
		 //sumMap: 장르별 재생 횟수 총합을 계산
		 Map<String, Integer> sumMap = new HashMap<String, Integer>();
		 int arrLength = genres.length;
		 for(int i=0; i<arrLength; i++) {
			 String genre=genres[i];
			 if(sumMap.containsKey(genre)) {
				 sumMap.put(genre, sumMap.get(genre)+plays[i]);
			 }else {
				 sumMap.put(genre, plays[i]);
			 }
		 }
		 		
		 //playMap: 각 장르별로 맵을 하나씩 생성. 그 맵에는 입력배열의 인덱스와 플레이횟수를 저장.
		 //플레이횟수별로 정렬하되 인덱스도 함께 움직여야 하니까. 그래야 고유번호를 answer에 넣지.
		 Map<String, HashMap<Integer,Integer>> playMap = new HashMap<String, HashMap<Integer,Integer>>();
		 for(int i=0; i<arrLength; i++) {
			 String genre = genres[i];
			 if(!playMap.containsKey(genre)) {
				 playMap.put(genre, new HashMap<Integer,Integer>());
			 }
			 HashMap<Integer,Integer> eachMap = playMap.get(genre);
			 eachMap.put(i,plays[i]);
		 }
		 
		 
		 //재생 횟수 총합 정렬
		 List<String> gTotal = new ArrayList<>(sumMap.keySet());
		 Collections.sort(gTotal, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {			
				return sumMap.get(o1).compareTo(sumMap.get(o2))*-1;
			}
		 });
		 
	     		 
		 //장르별 정렬. 
		 List<Integer> result = new ArrayList<Integer>();
		 for(String genre: gTotal) {
			 HashMap<Integer,Integer> eachMap = playMap.get(genre);
			 List<Integer> gEach = new ArrayList<>(eachMap.keySet());
			 Collections.sort(gEach, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {	
						int comparison = eachMap.get(o1).compareTo(eachMap.get(o2));
						return comparison*-1; 
					}	 
			 });
			 
			 //limit개까지 결과에 입력
			 int forMax = gEach.size()>=limit? limit:gEach.size();
			 for(int q=0; q<forMax; q++) {
				 result.add(gEach.get(q));
			 }
		 }
		 
		 //answer에 옮기자.
		 int[] answer = new int[result.size()];
		 for(int i=0; i<result.size(); i++) {
			 answer[i] = result.get(i);
			 
		 }
	     return answer;
	 }

	 
	 public int[] solution_sysout(String[] genres, int[] plays) {		 
		 //수록 제한
		 int limit = 2;
		 		 
		 //sumMap: 장르별 재생 횟수 총합을 계산
		 Map<String, Integer> sumMap = new HashMap<String, Integer>();
		 int arrLength = genres.length;
		 for(int i=0; i<arrLength; i++) {
			 String genre=genres[i];
			 if(sumMap.containsKey(genre)) {
				 sumMap.put(genre, sumMap.get(genre)+plays[i]);
			 }else {
				 sumMap.put(genre, plays[i]);
			 }
			 System.out.println("genre["+genres[i]+"], play["+plays[i]+"]");
		 }
		 System.out.println("-");
		 		
		 //playMap: 각 장르별로 맵을 하나씩 생성. 그 맵에는 입력배열의 인덱스와 플레이횟수를 저장.
		 //플레이횟수별로 정렬하되 인덱스도 함께 움직여야 하니까. 그래야 고유번호를 answer에 넣지.
		 Map<String, HashMap<Integer,Integer>> playMap = new HashMap<String, HashMap<Integer,Integer>>();
		 for(int i=0; i<arrLength; i++) {
			 String genre = genres[i];
			 if(!playMap.containsKey(genre)) {
				 playMap.put(genre, new HashMap<Integer,Integer>());
			 }
			 HashMap<Integer,Integer> eachMap = playMap.get(genre);
			 eachMap.put(i,plays[i]);
		 }
		 
		 
		 //재생 횟수 총합 정렬
		 List<String> gTotal = new ArrayList<>(sumMap.keySet());
		 Collections.sort(gTotal, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {			
				return sumMap.get(o1).compareTo(sumMap.get(o2))*-1;
			}
		 });
	     	
		 //장르별 총합 정렬 결과?
		 System.out.println("-----------------sort"); 
		 for(String key : gTotal) {
			 System.out.println(String.format("Key : %s, Value : %s", key, sumMap.get(key))); 
		 }
		 
	     		 
		 //장르별 정렬. 
		 List<Integer> result = new ArrayList<Integer>();
		 for(String genre: gTotal) {
			 HashMap<Integer,Integer> eachMap = playMap.get(genre);
			 List<Integer> gEach = new ArrayList<>(eachMap.keySet());
			 Collections.sort(gEach, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {	
						int comparison = eachMap.get(o1).compareTo(eachMap.get(o2));
						return comparison*-1; 
					}	 
			 });
			 
			 System.out.println("---");
			 for(Integer k: gEach) {
				 System.out.println(String.format("Key : %s, Value : %s", k, eachMap.get(k)));
			 }
			 
			 //limit개까지 결과에 입력
			 int forMax = gEach.size()>=limit? limit:gEach.size();
			 for(int q=0; q<forMax; q++) {
				 result.add(gEach.get(q));
			 }
		 }
		 
		 //answer에 옮기자.
		 System.out.println("result: " + result.toString());	
		 int[] answer = new int[result.size()];
		 for(int i=0; i<result.size(); i++) {
			 answer[i] = result.get(i);
			 
		 }
	     return answer;
	 }
}







