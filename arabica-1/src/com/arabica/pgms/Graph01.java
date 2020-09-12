package com.arabica.pgms;

import java.util.LinkedList;

public class Graph01 {

	public static void main(String[] args) {
		
		System.out.println("#----------------------#");
		Graph01 sol = new Graph01();
		
		//Params
		int[][] vert = new int[][] { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2} };  //
		int n = 6;
		
		int result = sol.solution(n, vert);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-08-02 프로그래머스 연습문제
	 * 그래프 - 가장 먼 노드
	 * 
	 * 샘플 정답(1=0, 2=1, 3=1, 4=2, 5=2, 6=2) 각 거리들. 거리의 절대값 자체는 중요하지 않다. 
	 * 문제1,2,3은 통과. 나머지 시간초과 케이스에 걸림.
	 * 현재 방식은 각 노드 한개에 대하여 거리를 탐색하는 거라서, 무조건 노드 개수만큼 함수를 돌려야 함.
	 * 그래서 오래 걸릴 수 밖에 없다.
	 * 
	 * BFS방식 이용하여 새로 코드 짠다.
	 * @date 2020-08-16 
	 */
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        GraphNodes gn = new GraphNodes(n);
        for(int i=0; i<edge.length; i++) {
        	//양방향이니까 다 추가
    		gn.addEdge(edge[i][0], edge[i][1]);
    		gn.addEdge(edge[i][1], edge[i][0]);
        }
        
        int[] resultDist = new int[edge.length+1];
        for(int i=1; i<=n; i++) {
        	int rd = gn.start(i);
        	resultDist[rd]++;
        	System.out.println("Result Distance["+i+"]: " + rd);
        	System.out.println("- - - - --  -- -  -- - --");        	
        }
        
        for(int i=resultDist.length-1; i>0; i--) {
        	if( resultDist[i] > 0) return resultDist[i];
        }
        
        return answer;
    }

	class GraphNodes {
		private Boolean[] visited;
		private LinkedList<Integer>[] adj; //각 노드별 인접노드들.
		
		public GraphNodes(int nodeLen) {
			this.visited = new Boolean[nodeLen+1];
			this.adj = new LinkedList[nodeLen+1];
		}
		
		void addEdge(int src, int dest) {
			if(adj[src] == null) adj[src] = new LinkedList<Integer>();
			if(!adj[src].contains(dest)) adj[src].add(dest);
		}
		
		private int start(int target) {
			int dist = 0;
			int currentNode = 1;
			
			//새로 돌때마다 초기화
			this.visited = new Boolean[adj.length];
			dist = findDistance(currentNode, dist, target);
			return dist;
		}
		
		//1번 노드부터의 거리
		private int findDistance(int currentNode, int dist, int target) {
			System.out.println("currentNode["+currentNode+"], dist["+dist+"], target["+target+"].");
			//거리+
			dist++;			
			
			if(currentNode == target) {
				visited[currentNode] = false;
				return dist;//현재노드가 target이면 지금까지의 거리를 리턴.
			}
			
			//현재노드의 인접리스트	
			LinkedList<Integer> currentAdj = adj[currentNode]; 	
			//인접리스트에 target이 포함되어 있으면 즉시 리턴.
			if(currentAdj.contains(target)) {
				visited[currentNode] = false;
				return ++dist;
			}
			
			visited[currentNode] = true;
			int min = 50001;
			for(Integer next : currentAdj) {
				//System.out.println("...currnet["+currentNode+"]...next: " + next + ", visit[" + visited[next] + "]");
				if(visited[next] != null && visited[next]) continue;
				
				int nextDist = findDistance(next, dist, target);
				if(nextDist >= 0 && nextDist < min) {
					min = nextDist;
					//System.out.println("get nextDist["+nextDist+"]");
				}
			}
			
			visited[currentNode] = false;
			//System.out.println("return min: " + min);
			if(min >= 50001) return -1;
			return min;
		}
		
		
	}
	
}
