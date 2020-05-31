package com.arabica.pgms;

import java.util.LinkedList;

public class Dfs2 {

	public static void main(String[] args) {
		
		System.out.println("#----------------------#");
		Dfs2 dfs = new Dfs2();
		
		//Params
		//int[][] coms = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};  //정답2
		int[][] coms = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};  //정답1
		int n = 3;
		
		int result = dfs.solution(n, coms);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-05-31 프로그래머스 연습문제
	 * 깊이/너비 우선탐색 - 네트워크
	 * 
	 * 1) 독립된 경로의 개수가 몇개 인지 파악하는 문제.
	 * 2) 인터넷에 올라온 기본 DFS 구현방법을 적용하되, 경로의 개수를 관리할 parent라는 개념을 추가.
	 * 3) 0번 기준 노드를 탐색. 0번에 연결된 다른 컴퓨터를 기준으로 탐색. 
	 *    이 때 0번에 연결된걸 확장해서 찾는거니까, parent를 0으로 지정하고 다음 노드를 탐색.
	 * 4) 연결된 노드를 찾을 때 마다, 이 newNode기준으로 재귀함수 호출. (깊이 우선 방식)
	 * 5) visited 배열을 이용해서 현재 노드가 이미 탐색한 컴퓨터라면 바로 return.
	 * 6) 3~5번 절차를 통해 0번 기준 하위 컴퓨터까지 모두 돌았으면,
	 *    start() 함수에서 다음 노드인 1번 컴퓨터를 parent로 하여 다음 탐색(traceNet)을 시작한다.
	 * 7) 1번 컴퓨터가 visited 체크된거면 패스, 아니면 3~5번 절차를 진행하면서 새로운 parent 리스트를 작성.
	 * 8) start()에서 모든 parent를 다 체크했으면. 0이 아닌 adj[]의 개수를 answer로 반환한다.
	 * 
	 * 9) 다른사람은 DFS가 호출된 횟수만 리턴하는 방법으로 풀이함. 즉, 경로 정보는 필요없고 연결된 경로가 
	 *    몇 개인지만 알면 되니까... 나는 굳이 정보까지 관리하려 해서 코드가 복잡해짐.
	 * @date 2020-05-31 완료.
	 */
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        NetworkSearch ns = new NetworkSearch(n, computers);
        ns.start();
        answer = ns.getResult();
        
        return answer;
    }
	
	class NetworkSearch {
		private int[][] input;
		private LinkedList<Integer>[] adj;
		private Boolean[] visited;
		int parent;
		
		NetworkSearch(int n, int[][] computers) {
			adj = new LinkedList[n];
			visited = new Boolean[n];	
			input = computers.clone();
		}
		
		void addEdge(int i, int j){
			if(adj[i] == null) adj[i] = new LinkedList<Integer>();
			adj[i].add(j);
		}
		
		void start() {
			for(int i=0; i<input.length; i++) {
				//parent와 host를 i번째 컴퓨터로 지정하여 새로운 탐색을 진행한다.
				traceNet(i,i);
			}
		}
		
		//null이 아니고 사이즈가 1이상인 adj[i]의 개수를 반환한다.
		int getResult() {
			int count=0;
			for(int i=0; i<adj.length; i++) {
				if(adj[i] != null && adj[i].size() > 0) count++;
			}
			return count;
		}
		
		void traceNet(int parent, int host) {
			System.out.println("host: " + host + ", visited: " + visited[host]);
			if(visited[host] != null && visited[host]) return;
			
			visited[host] = true;
			
			int tr = 0;
			int fa = 0;
			for(int a=0; a<input[host].length; a++) {
				if(input[host][a] == 1) {
					tr++;
					//현재 host의 parent의 리스트에 추가함.
					addEdge(parent, a);
					traceNet(parent, a);
				}else {
					fa++;
				}
			}
			
			
			System.out.println("parent[" + parent + "]: " + adj[parent] + "true["+tr+"],false["+fa+"]");
		}
		
	}
	

}
