package com.arabica.main;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapCode {
	
	static List<Integer> heap;
	
	public static void main(String[] args) {
		
		System.out.println("heap test");
		HeapCode hc = new HeapCode();
		
		int[] scoville = new int[] {17,2,3,9,10,12};
		System.out.println("hc result: " + hc.solution(scoville, 7));
	}
	
	
	/**
	 * 2020-01-01 다른 사람 풀이 참고해서 작성.
	 * 기존 효율성 시험에서 실패하던걸 보완.
	 * PriorityQueue는 최소힙.
	 * 완전이진트리는 최초에 완전 정렬된 상태에서 시작하면 정렬구조는 깨지지 않음.
	 * 
	 */
	public int solution(int[] scoville, int K) {
        int answer = -1;
        int tail1, tail2 =0;
        int newval = 0;
        int times = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>(scoville.length);
        Queue<Integer> pq2 = new PriorityQueue<Integer>(scoville.length);
        
        for(int i=0; i<scoville.length; i++) {
        	priorityQueue.offer(scoville[i]);
        	
        	//test: 정렬이 바로 되는지 확인차 추가함.
        	pq2.offer(scoville[i]);
        	System.out.println("PQ peek: " + priorityQueue.peek());
        }
       
        //TEST : 정렬이 잘 된건지 확인차 추가함.
        /*
        int pq2size = pq2.size();
        for(int i=0; i< pq2size; i++) {
        	System.out.println("PQ2 List: " + pq2.poll());
        }*/
        
        System.out.println("scoville length: " + scoville.length);
        System.out.println("priorityQueue size: " + priorityQueue.size());
        
        while(priorityQueue.size() > 1) {
        	if(priorityQueue.peek() >= K) {
        		answer = times;
        		break;
        	}else {
        		tail1 = priorityQueue.poll();
        		tail2 = priorityQueue.poll();
        		newval = tail1 + (tail2*2);
        		priorityQueue.offer(newval);
        		times++;
        	}
        }
        
        //하나만 있을 경우. K넘으면 0, 아니면 -1.
        if(priorityQueue.size() == 1) {
        	if(priorityQueue.peek() >= K) {
        		answer = times;
        	}
        }
        
        return answer;
    }
	

}



