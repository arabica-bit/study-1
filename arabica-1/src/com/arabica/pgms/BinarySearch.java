package com.arabica.pgms;

import java.util.Arrays;

public class BinarySearch {


	public static void main(String[] args) {
		
		System.out.println("BinarySearch algorithm.");
		BinarySearch bs = new BinarySearch();
		
		//Params		
		int[] _budgets = new int[] {120, 110, 140, 150};
		int _m = 485; 
		//520이면 답은 150, 485이면 답은 127, 4는 1.
		
		int result = bs.solution2(_budgets, _m);
		System.out.println("result: " + result);
		
	}
	
	/**
	 * 2020-02-23 프로그래머스 문제 풀이
	 * 이분탐색기법
	 * 
	 * 1) 이분 탐색 기본 구현방법을 그대로 적용함.
	 * 2) 다음 mid를 구할 때, 왜 end 혹은 start에 +1, -1을 하는지 명확히 이해하진 못함...
	 * 	-> 종료조건을 만들기 위해 +1,-1하는것같다. 
	 *  -> 다른 방법으로도 종료조건을 만들수 있다.(@this.solution2)
	 * 3) 분배 후 예산작액이 0이상이면 무조건 오른쪽, 0미만이면 왼쪽으로 이동해서 끝까지 탐색하는 방법.
	 * 4) 상대적으로 어려울 줄 알았는데, 문제의 주제를 알고 푸니까 생각보다 쉽게 풀림...시간은 걸렸지만..
	 * 
	 * @date 2020-02-23 완료.
	 */
	public int solution(int[] budgets, int M) {
        int answer = -1;
        
        System.out.println("## before sorting:1 ");
        //printArray(budgets);
        Arrays.sort(budgets);        
        System.out.println("## after sorting: ");
        //printArray(budgets);
        
        int start = 1;
        int end = budgets[budgets.length-1];
        int mid = end; // 가장 큰 값을 찾는거니까 큰 값부터 시작해본다.
        
        while((end - start) >= 0) {
        	int current = dist(budgets, M, mid);
        	System.out.println("start["+start+"], end["+end+"], mid["+mid+"]");
        	System.out.println("currrent["+current+"]");
        	System.out.println("--------------------------------------------------");
        	if(current < 0) {
        		end = mid-1;
        	}else{ 
        		start = mid+1;
        	}
        	mid = (start+end)/2;
        }
        
        answer = mid;
        return answer;
    }
	
	public int solution2(int[] budgets, int M) {
        int answer = -1;
        
        System.out.println("## before sorting: 2");
        //printArray(budgets);
        Arrays.sort(budgets);        
        System.out.println("## after sorting: ");
        //printArray(budgets);
        
        int start = 1;
        int end = budgets[budgets.length-1];
        int mid = end; // 가장 큰 값을 찾는거니까 큰 값부터 시작해본다.

        int prev = -1;
        while(mid != prev) {
        	int current = dist(budgets, M, mid);
        	System.out.println("start["+start+"], end["+end+"], mid["+mid+"]");
        	System.out.println("currrent["+current+"]");
        	System.out.println("--------------------------------------------------");
        	if(current < 0) {
        		end = mid;
        	}else{ 
        		start = mid;
        	}
        	prev = mid;
        	mid = (start+end)/2;
        }
        
        answer = mid;
        return answer;
    }
	
	//예산분배
	public int dist(int[] budgets, int M, int limit) {
		for(int bud : budgets){
			if(M < 0) return M;
			if(limit >= bud) {
				M = M-bud;
			}else {
				M = M-limit;
			}
		}
		return M;
	}
	
	public void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] : " + arr[i]);
		}
	}



}
