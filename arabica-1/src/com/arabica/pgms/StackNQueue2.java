package com.arabica.pgms;

import java.util.Stack;

public class StackNQueue2 {

	
	public static void main(String[] args) {
		System.out.println("#----------------------#");
		StackNQueue2 sol = new StackNQueue2();
		
		//Params
		int[] heights = new int[] {6,9,5,7,4};
		
		int[] result = sol.solution(heights);
		
		System.out.println("\n---result---");
		for(int r: result) {
			System.out.println(r);
		}
	}
	
	/**
	 * 2020-07-12 프로그래머스 연습문제
	 * 스택/큐 - 탑
	 * 
	 * 0) 주어진 배열에서 각 항목보다 높은 값의 인덱스를 찾는 문제. 가장 가까운 왼쪽 방향만 허용함.
	 * 0) 값이 아니라 인덱스를 찾아야 하고, 조건이 안맞으면 0으로 지정해야 함.
	 * 
	 * 1) answer 배열을 0으로 초기화. 이렇게 하면 정답을 찾은 index의 값만 바꾸면 된다.
	 * 2) 신호를 보낸 타워의 위치(index)를 스택으로 저장.
	 * 3) 배열의 오른쪽 끝부터 0 인덱스 방향으로 순차 탐색.
	 * 4) for문의 i번째 타워가 수신할 타워라고 생각하고, 스택에 저장된 항목과 높이를 비교하면 된다.
	 * 5) 대상탑(i)가 송신탑(stack.peek)보다 높으면 그 위치(i+1)를 송신결과(answer[i])에 저장함.
	 * 6) 송신결과에 저장할 위치는 1부터 시작이라, i+1로 저장함을 주의.
	 * 
	 * @date 2020-07-12 완료.
	 * 
	 */
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        Stack<Integer> signalIdx = new Stack<>();
        
        int len = heights.length;
        //탑의 가장 오른쪽부터 왼쪽 방향으로 검사.
        for(int i=len-1; i>=0; i--) {
        	Integer rcvHeight = heights[i];
        	System.out.println("now: " + heights[i]);
        	
        	check:while(!signalIdx.isEmpty()) {
        		Integer senderHeight = heights[signalIdx.peek()];
        		System.out.println("senderHeight["+senderHeight+"], rcvHeight["+rcvHeight+"]");
        		if(rcvHeight.compareTo(senderHeight) > 0) {
        			//대상탑이 송신탑보다 높다-> 대상탑의 위치 입력.
        			//위치는 1부터 시작 주의.
        			answer[signalIdx.pop()] = i+1;        			
        		}else {
        			break check;
        		}
        	}
        	
        	signalIdx.push(i);
        }        
        
        return answer;
    }
	
}
