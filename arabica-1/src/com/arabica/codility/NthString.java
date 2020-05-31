package com.arabica.codility;

public class NthString {
	
	public static void main(String[] args) {
		
		System.out.println("---start---");
		NthString sol = new NthString();
		
		String param1 = "bytdag";
		int[] param2 = new int[] {4, 3, 0, 1, 2, 5};
		String result = sol.solution(param1, param2);
		
		System.out.println("### result : " + result);
	}
	
	/**
	 * 2020-05-17  Codility 테스트 - 네이버파이낸셜
	 * (task이름은 컨닝의 우려인지 알려주지 않았음)
	 * 
	 * 1) 동일한 길이의 문자열S와 순서A가 주어진다. 배열을 탐색하는 문제.
	 * 2) 알고리즘 구현하는 것보단 문제에 대한 정확한 이해에 시간이 많이 소모됨.
	 * 3) 
	 * 
	 * @결과: 정확도100%, 성능(평가X)
	 */
	public String solution(String S, int[] A) {
        
		String[] Sarr = S.split("");
		int N = A.length;
		
		int k = 0;
		StringBuilder sb = new StringBuilder();
		do  {			
			sb.append(Sarr[k]);
			k=A[k];	
			if(k>(N-1)) return sb.toString();
					
		}while(k>0);
		
		System.out.println("sb: " + sb.toString());
		
		return sb.toString();
    }
	
	
}

/**
*There are N people, numbered from 0 to N-1, playing a game. The K-th person is assigned the letter S[K]. At the beginning the 0th person sends a message, consisting of a single letter S[0], to the A[0]-th person. When the K-th person receives the message, they append their letter S[K] to the message and forward it to A[K]. The game ends when the 0th person receives the message. Find the final message.

You can assume that A contains every integer from 0 to N-1 exactly once.

that given a string S and an array of integers A, both of length N, returns a string denoting the final message received by the 0th person.

Examples:

1. Given S = "cdeo" and A = [3, 2, 0, 1], your function should returns "code". At the beginning, the 0th person sends a message "c" to the 3rd person. Next, the 3rd person forwards the message "co" to the 1st person. After that the 1st person forwards the message "cod" to the 2nd person. After appending the letter 'e' to it, the 2nd person forward it to the 0th person. The final message, received by 0th person, is "code".

2. Given S = "cdeenetpi" and A = [5, 2, 0, 1, 6, 4, 8, 3, 7], your function should returns "centipede".

3. Given S = "bytdag" and A = [4, 3, 0, 1, 2, 5], your function should returns "bat". Notice, that not all letters from S have to be used.

Assume that:


...성능은 고려하지 말고, 정확도만 고려할것.
*/