package com.arabica.pgms;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {

	public static void main(String[] args) {
		System.out.println("#----------------------#");
		Queue1 sol = new Queue1();
		
		//Params
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = new int[] {7,4,5,6};
		//int[] truck_weights = new int[] {10};
		
		int result = sol.solution(bridge_length, weight, truck_weights);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-06-21 프로그래머스 연습문제
	 * 스택/큐 - 다리를 지나는 트럭
	 * 
	 * 0) 주어진 트럭들이 무게 제한이 있는 다리를 통과하는 시간 찾기.
	 * 0) 가장 빨리 통과하는 트럭의 조합을 찾는게 아니라 주어진 순서대로 통과하는 것.
	 * 
	 * 1) 대기중인 트럭은 truck 큐. 다리위에 있는 트럭은 bridge 큐.
	 * 2) 다리를 완전히 통과하지 않은 트럭의 대수를 left로 둔다. 초기값은 truck큐의 size와 같다.
	 * 3) 다리를 다 빠져나온 트럭(무게0초과)이 있으면 left를 차감하고, left가 0이 되면 루프 종료.
	 * 4) 한 루프마다 경과시간(seconds) 1증가.
	 * 5) 1초가 지나야 종료 조건을 검사할 수 있으니, do-while문을 사용.
	 * 6) 예상하중과 최대하중을 비교할 때, lt('<')가 아니라 le('<=')를 사용해야 하는거 헷갈리지 말자.
	 * 
	 * 7) 연습을 좀 쉬었더니, 너무 오래 걸렸다. 4시간...??
	 * 
	 * @date 2020-06-21 완료.
	 */
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Object> truck = new LinkedList<>();
        for(int a : truck_weights) {
        	truck.offer(a);
        }
        
        Queue<Object> bridge = new LinkedList<>();
        int current = 0;
        int seconds = 0;
        int left = truck_weights.length;
        do {
        	System.out.println("Truck  size["+truck.size()+"], Peek["+truck.peek()+"] ");
        	System.out.println("Bridge size["+bridge.size()+"], Peek["+bridge.peek()+"] ");
        	System.out.println("Left: "+ left);
        	//다리를 다 지난 트럭을 꺼내고.
        	if(bridge.size() >= bridge_length) {
        		int end = (int)bridge.poll();
        		current -= end;
        		if(end > 0) left--;
        	}
        	
        	System.out.println("before : " + bridge.size());
        	//무게 여유가 있으면, 다음 트럭이 진입.
        	/*
        	 * 엄밀히 말하면 약간의 버그 있음. 원래 진입 가능한 트럭이 있으면 if 블록으로 가고, 
        	 * 무게가 초과하거나 대기중인 트럭이 없으면 else 블록으로 가야함.
        	 * 그런데 대기중인 트럭이 없으면 무게가 0인 트럭이 되어서, (else로 가야하지만) if블록에 진입함.
        	 * 값이 0이라 사실 논리적으론 문제 없지만, 내가 의도하지 않은 분기를 타게 되는 것이다.
        	 * 즉, 대기중인 트럭이 없으면 무게를 weight+1로 세팅해서, else블록으로 유도해야 하지만, 
        	 * 나중에 이해하기 어려울까봐 그냥 둔다.
        	*/
        	int kg = truck.isEmpty()? 0:(int)truck.peek();
        	if((current+kg) <= weight) {	
        		bridge.offer(truck.poll());
        		current += kg;
        		System.out.println("Put truck : " + kg);
        	}else {
        		//여유가 없으면 무게 "0"인 트럭 진입.
        		bridge.offer(0);
        		System.out.println("Put zero truck  ");
        	}
        	
        	System.out.println("after : " + bridge.size());
        	//경과 시간
        	seconds++;
        	System.out.println(seconds + "- - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        } while(left > 0);
                      
        return seconds;
    }
}
