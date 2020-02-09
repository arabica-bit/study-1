package com.arabica.main;

import java.util.HashMap;
import java.util.Map;

public class Bruteforce {

	public static void main(String[] args) {
		
		System.out.println("Exhaustive search--");
		Bruteforce bf = new Bruteforce();
				
		//int[] answers = new int[] {1,3,2,4,2,1,3,2,4,2};
		int[] answers = new int[] {2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		//int[] answers = new int[] {8,8};
		int[] result = bf.solution(answers);
		
		for(int i=0; i<result.length; i++) {
			System.out.println("result[" + i + "]: " + result[i]);
		}
		
	}
	
	/**
	 * 2020-01-01 프로그래머스 문제 풀이
	 * brute force 방식의 구현
	 * 
	 * 1) 0점 아닌 사람을 정렬하는게 어려웠음. --> 최고점수인 사람만 찾는걸 진작 깨달았더라면, 좀더 빨리 해결했을 텐데...
	 * 2) 테스트 케이스 10, 11, 12번에서 실패함. --> Integer의 비교는 무조건 equals, compareTo를 이용해야 함.
	 * 3) 최고점수인 사람만 리턴하고, 동점인 경우만 오름차순으로 리턴.
	 * 4) 모두 틀리면 최고 점수가 0점이므로, 모든 유저를 오름차순으로 리턴한다.
	 * @date 2020-01-05 완료. 
	 *
	 */
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] user1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        //정답
        Map<Integer, Integer> vals = new HashMap<Integer, Integer>();
        vals.put(1,comp(user1, answers));
        vals.put(2,comp(user2, answers));
        vals.put(3,comp(user3, answers));
        
        //정렬
        int[] sort = {1,2,3};
        
        //TEST
        System.out.println("Count a: " + vals.get(sort[0]));
        System.out.println("Count b: " + vals.get(sort[1]));
        System.out.println("Count c: " + vals.get(sort[2]));

        if(vals.get(sort[0]).compareTo(vals.get(sort[1])) < 0) {
        //if(vals.get(sort[0]) < vals.get(sort[1])) {
        	int temp = sort[0];
        	sort[0] = sort[1];
        	sort[1] = temp;
        }
        if(vals.get(sort[0]).compareTo(vals.get(sort[2])) < 0) {
        //if(vals.get(sort[0]) < vals.get(sort[2])) {
        	int temp = sort[0];
        	sort[0] = sort[2];
        	sort[2] = temp;
        }
        if(vals.get(sort[1]).compareTo(vals.get(sort[2])) < 0) {
        //if(vals.get(sort[1]) < vals.get(sort[2])) {
        	int temp = sort[1];
        	sort[1] = sort[2];
        	sort[2] = temp;
        }
        
        System.out.println("sort 1: " + sort[0]);
        System.out.println("sort 2: " + sort[1]);
        System.out.println("sort 3: " + sort[2]);
        
        //결과정리
        int zn = 0;
        if(vals.get(sort[0]) > 0) {
        	zn++;
        	if(vals.get(sort[1]).equals(vals.get(sort[0]))) zn++;
            if(vals.get(sort[2]).equals(vals.get(sort[0]))) zn++;
        }else {
        	zn=3;
        }
        answer = new int[zn];
        for(int i=0; i<zn; i++) {
        	answer[i] = sort[i];
        }
        
        return answer;
    }
	
	private int comp(int[] user, int[] ans) {
		int count=0;
        for(int i=0; i<ans.length; i++) {
        	if(user[i%user.length] == ans[i])
        		count++;
        }
		
		return count;
	}
	
	
	
}

