package com.arabica.pgms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph01_b {
	
	public static void main(String[] args) {
		
		System.out.println("#----------------------#");
		Graph01_b sol = new Graph01_b();
		
		//Params
		int[][] vert = new int[][] { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2} };  //
		int n = 6;
		
		int result = sol.solution_sysout(n, vert);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-08-17 새로 작성
	 * 그래프 - 가장 먼 노드 (풀이2)
	 * 
	 * 너비탐색(BFS) 방식으로 새로 작성. (Queue를 이용하면 너비 탐색을 구현할 수 있다)
	 * Queue를 쓰면 for loop 한개로 인접 노드를 모두 탐색 후 그 하위 노드로 넘어가도록 할 수 있음.
	 * 현재 depth가 distanceArr에 저장된 depth보다 크면, 더 이상 검사할 필요가 없다는 점을 이용.
	 * 	-> 루프가 진행될 수록 depth는 커지기만 하므로, 이미 최단거리를 찾았다고 볼수 있는 상황이다.
	 * 
	 * Map, List를 다양하게 사용했지만 실제로 ArrayList하나로도 처리 가능하다.
	 * 
	 * 이제 어렴풋이 BFS에 대해 이해한 것 같다.
	 * @date 2020-08-17 완료
	 */
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        //1번 노드와의 최단거리
        Integer[] distanceArr = new Integer[n+1];        
        int max = edge.length+1;
        
        //인접 노드 리스트 & 거리배열 초기화
        Map<Integer, List<Integer>> connection = new HashMap<>();
        for(int i=1; i<=n; i++) {
        	List<Integer> adjs = new ArrayList<Integer>();
        	connection.put(i, adjs);
        	distanceArr[i] = max;
        }
        
        //인접 노드 정리
        for(int i=0; i<edge.length; i++) {
        	int src = edge[i][0];
        	int dest = edge[i][1];
        	List<Integer> adjs = connection.get(src);
        	adjs.add(dest);
        	adjs = connection.get(dest);
        	adjs.add(src);
        }
        
        //탐색 큐
        Queue<Integer> queue = new LinkedList<>();        
        int depth = 0;
        distanceArr[1] = depth;
        queue.offer(1);
        //BFS
        while(!queue.isEmpty()) {        	
        	Integer node = queue.poll();
        	depth = distanceArr[node]+1;
        	List<Integer> nodeAdj = connection.get(node);
        	for(Integer adj : nodeAdj) {
    			int savedDist = distanceArr[adj];
    			if(depth < savedDist) {
    				distanceArr[adj] = depth;
    				queue.offer(adj);
    			}
    		}
        }
        
        //먼거리 체크
        max = -1;
        for(int i=1; i<distanceArr.length; i++) {
        	if(distanceArr[i] > max) {
        		max = distanceArr[i];
        		answer = 1;
        	}else if(distanceArr[i] == max) {
        		answer += 1;
        	}
        }
        
        return answer;
    }
	
	
	public int solution_sysout(int n, int[][] edge) {
        int answer = 0;
        
        //1번 노드와의 최단거리
        Integer[] distanceArr = new Integer[n+1];        
        int max = edge.length+1;
        
        //인접 노드 리스트 & 거리배열 초기화
        Map<Integer, List<Integer>> connection = new HashMap<>();
        for(int i=1; i<=n; i++) {
        	List<Integer> adjs = new ArrayList<Integer>();
        	connection.put(i, adjs);
        	distanceArr[i] = max;
        }
        
        for(int i=0; i<edge.length; i++) {
        	int src = edge[i][0];
        	int dest = edge[i][1];
        	//System.out.println("s:" + s + ", d:" + d + "\n ----");
        	List<Integer> adjs = connection.get(src);
        	adjs.add(dest);
        	adjs = connection.get(dest);
        	adjs.add(src);
        }
        
        //test
        for(Integer key : connection.keySet()) {
        	System.out.println("connectionKey["+key+"] : " + connection.get(key));
        }
        
        //탐색 큐
        Queue<Integer> queue = new LinkedList<>();
        int depth = 0;
        distanceArr[1] = depth;
        queue.offer(1);       
        //BFS
        while(!queue.isEmpty()) {        	
        	Integer node = queue.poll();
        	depth = distanceArr[node]+1;
        	System.out.println("---next node : " + node);
        	List<Integer> nodeAdj = connection.get(node);
        	for(Integer adj : nodeAdj) {
    			int savedDist = distanceArr[adj];
    			System.out.print("...current:"+adj+", savedDist["+savedDist+"], depth["+depth+"]..");
    			if(depth < savedDist) {
    				distanceArr[adj] = depth;
    				queue.offer(adj);
    				System.out.println(" -> offer");
    			}else {
    				System.out.println(" -> X");
    			}
    		}
        }
        
        //test
        for(int a=0; a<distanceArr.length; a++) {
        	System.out.println("Arr[" + a + "]: " + distanceArr[a]);
        }
        
        //먼거리 체크
        max = -1;
        for(int i=1; i<distanceArr.length; i++) {
        	if(distanceArr[i] > max) {
        		max = distanceArr[i];
        		answer = 1;
        	}else if(distanceArr[i] == max) {
        		answer += 1;
        	}
        }
        
        return answer;
    }
	
	
}


