package com.arabica.pgms;

public class DepthFirstSearch {

	public static int way = 0;
	public static int sol = 0;
	public static void main(String[] args) {
		
		System.out.println("DFS algorithm.");
		System.out.println("#----------------------#");
		DepthFirstSearch dfs = new DepthFirstSearch();
		
		//Params
		int[] numbers = new int[] {1,1,1,1,1};
		int target = 3;
		
		int result = dfs.solution(numbers, target);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-02-16 프로그래머스 문제 풀이
	 * DFS 구현
	 * 
	 * 1) 재귀함수 방식으로 풀었다. stack으로도 구현할 수 있으나 여기선 사용하지 않았다.
	 * 2) order를 search(numbers, sum, order++, 1)했더니, order가 증가하지 않아 무한루프에 빠졌다.
	 * 3) ++order로 바꾸거나 지금 풀이처럼 미리 증가시켜놓을 것.
	 * 4) 마커라는 파라미터를 따로 두지 않고 입력 파라미터에 +sum, -sum하는 방식으로 
	 *    파라미터를 하나 줄일수 있던데, 나는 생각못했다.
	 *    
	 * @date 2020-02-16 완료.
	 */
	public int solution(int[] numbers, int target) {
        int answer = 0;
        sol = target;
        
        search(numbers, 0, 0, +1);
        search(numbers, 0, 0, -1);        
        
        answer = way;
        return answer;
    }
	
	public void search(int[] numbers, int sum, int order, int marker) {
		sum = sum + (marker*numbers[order]);
		System.out.println("numbers[" + order + "]: " + numbers[order]);
		System.out.println("marker: " + marker);
		System.out.println("sum: " + sum);
		System.out.println("target: " + sol);
		System.out.println("#----------------------#");
		
		if(numbers.length-1 == order) {
			if(sol == sum) {
				way++;
			}
			return;
		}else {
			order++;
			search(numbers, sum, order, 1);
			search(numbers, sum, order, -1);	
		}
	}
	
	
	
}
