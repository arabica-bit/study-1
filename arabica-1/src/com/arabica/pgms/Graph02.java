package com.arabica.pgms;

public class Graph02 {
	
	public static void main(String[] args) {
		System.out.println("#----------------------#");
		Graph02 sol = new Graph02();
		
		//Params
		int[][] vert = new int[][] { {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5} };  //
		int n = 5;
		
		int result = sol.solution_sysout(n, vert);
		System.out.println("result: " + result);
	}
	
	/**
	 * 2020-08-23 프로그래머스 연습문제
	 * 그래프 - 순위 
	 * 
	 * 1)노드간의 승패가 정리된 배열을 바탕으로 순위가 확정된 노드의 개수를 찾는 문제
	 * 2)순위가 확정되었다는 것을 어떻게 판단하는지 전혀 감을 잡지 못했음.
	 * 3)검색을 통해 Floyd-Warshall 알고리즘으로 풀수 있다는 것을 확인함.
	 *   - 중간 경로가 최적인 것들을 선택하면, 최종 경로도 최적이라는 알고리즘.
	 *   - 두 노드간 연결사이에 다른 노드를 타고 가게하여, 최단거리를 갱신해나감. 
	 * 4) 풀이 순서: 초기화 -> 주어진 배열 입력 -> Floyd-Warshall알고리즘적용 
	 *                 -> 몇개의간선이생성되었는지카운팅 -> (n-1)보다 큰 값 리턴
	 * 
	 * @date 2020-08-30 완료
	 */
	public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = 98765;
        int[][] nodeMap = new int[n+1][n+1]; // 0번 인덱스는 사용하지 않음.
        
        //초기화
        for(int i=0; i<nodeMap.length; i++) {
        	for(int j=0; j<nodeMap.length; j++) {
        		if(i==j) nodeMap[i][j] = 0;
        		else nodeMap[i][j] = INF;
        	}
        }
        
        //주어진 간선 입력
        for(int i=0; i<results.length; i++) {
        	int src = results[i][0];
        	int dest = results[i][1];
        	nodeMap[src][dest] = 1;
        }
        
        //F-W (경유m, 시작s, 도착d)
        for(int m=1; m<=n; m++) {
        	for(int s=1; s<=n; s++) {
        		for(int d=1; d<=n; d++) {
        			if(nodeMap[s][d] > (nodeMap[s][m] + nodeMap[m][d]) ) 
        				nodeMap[s][d] = nodeMap[s][m] + nodeMap[m][d];
        		}
        	}
        }
                
        //각 노드가 몇개의 다른 노드와 연결되는지 카운트.
        int[] connection = new int[n+1];
        for(int i=1; i<nodeMap.length; i++) {
        	for(int j=1; j<nodeMap.length; j++) {
        		if(nodeMap[i][j] != 0 && nodeMap[i][j] < INF) 
        			connection[i]++;
        		if(nodeMap[j][i] != 0 && nodeMap[j][i] < INF) 
        			connection[i]++;
        	}
        }
        
        //(n-1)보다 큰 카운트를 갖는 노드의 개수를 센다.
        for(int i=0; i<connection.length; i++) {
        	if(connection[i] >= (n-1)) answer++;
        }
        
        return answer;
	}
	

	public int solution_sysout(int n, int[][] results) {
	        int answer = 0;
	        int INF = 98765;
	        int[][] nodeMap = new int[n+1][n+1]; // 0번 인덱스는 사용하지 않음.
	        
	        //초기화
	        for(int i=0; i<nodeMap.length; i++) {
	        	for(int j=0; j<nodeMap.length; j++) {
	        		if(i==j) nodeMap[i][j] = 0;
	        		else nodeMap[i][j] = INF;
	        	}
	        }
	        
	        //test
	        System.out.println("-----------------------------------");
	        for(int i=0; i<nodeMap.length; i++) {
	        	for(int j=0; j<nodeMap.length; j++) {
	        		System.out.print("["+nodeMap[i][j] + "]  ");
	        	}
	        	System.out.println("");
	        }
	        
	        //주어진 간선 입력
	        for(int i=0; i<results.length; i++) {
	        	int src = results[i][0];
	        	int dest = results[i][1];
	        	nodeMap[src][dest] = 1;
	        }
	        
	        
	        //test
	        System.out.println("-----------------------------------");
	        for(int i=0; i<nodeMap.length; i++) {
	        	for(int j=0; j<nodeMap.length; j++) {
	        		System.out.print("["+nodeMap[i][j] + "]  ");
	        	}
	        	System.out.println("");
	        }
	        
	        //F-W (경유m, 시작s, 도착d)
	        for(int m=1; m<=n; m++) {
	        	for(int s=1; s<=n; s++) {
	        		for(int d=1; d<=n; d++) {
	        			if(nodeMap[s][d] > (nodeMap[s][m] + nodeMap[m][d]) ) 
	        				nodeMap[s][d] = nodeMap[s][m] + nodeMap[m][d];
	        		}
	        	}
	        }
	        
	        //test
	        System.out.println("-----------------------------------");
	        for(int i=0; i<nodeMap.length; i++) {
	        	for(int j=0; j<nodeMap.length; j++) {
	        		System.out.print("["+nodeMap[i][j] + "]  ");
	        	}
	        	System.out.println("");
	        }
	        
	        
	        //각 노드가 몇개의 다른 노드와 연결되는지 카운트.
	        int[] connection = new int[n+1];
	        for(int i=1; i<nodeMap.length; i++) {
	        	for(int j=1; j<nodeMap.length; j++) {
	        		if(nodeMap[i][j] != 0 && nodeMap[i][j] < INF) 
	        			connection[i]++;
	        		if(nodeMap[j][i] != 0 && nodeMap[j][i] < INF) 
	        			connection[i]++;
	        	}
	        }
	        
	        //(n-1)보다 큰 카운트를 갖는 노드의 개수를 센다.
	        System.out.println("-----------------------------------");
	        for(int i=0; i<connection.length; i++) {
	        	System.out.println(connection[i] + "");
	        	if(connection[i] >= (n-1)) answer++;
	        }
	        
	        return answer;
	}
}
