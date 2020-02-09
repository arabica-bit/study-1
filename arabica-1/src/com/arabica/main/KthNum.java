package com.arabica.main;

import java.util.Arrays;

public class KthNum {
	/**
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
	 */

	public static void main(String[] args) {
		
		KthNum kn = new KthNum();
		
		int [] array = new int[] {1, 5, 2, 6, 3, 7, 4};
		int[][] cmds = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] temp = kn.solution(array, cmds);
		for(int i=0; i<temp.length; i++) {
			System.out.println("answer[" + i + "] : " + temp[i]);
		}
		
		int[] temp2 = Arrays.copyOfRange(array, 0,1);
		for(int i=0; i<temp2.length; i++) {
			System.out.println("temp2[" + i + "] : " + temp2[i]);
		}
	}
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        //각 커맨드에 대하여
        for(int i=0; i<commands.length; i++) {
        	int from = commands[i][0];
        	int to = commands[i][1];
        	//입력에서 from은 n번째 항목을 의미함. 카피할 때는 배열의 인덱스가 0부터 시작하니까 이를 고려하여 -1해줌
        	int[] result = Arrays.copyOfRange(array, from-1, to);
        	Arrays.sort(result);
        	//k번째 항목 찾는것도 동일함. 인덱스가 0부터 시작함을 고려하여 -1해줌.
        	answer[i] = result[commands[i][2]-1];
        }
        
        return answer;
    }
}
