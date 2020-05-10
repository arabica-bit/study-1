package com.arabica.basic;

import java.util.Arrays;

public class Permutation1 {

	int order = 1;
	
	/**
	 * 1) Arrays.copyOf를 사용해야 새로운 Array 생성된다.
	 * 2) 그림으로 그려야 이해됨. order변수는 호출 순서 보려고 넣은거. 
	 *  	@extra.xlsx 참고
	 * 3) Perm은 주어진 Depth와 일치하는 index의 항목과 나머지 오른쪽 항목을 스왑한다.
	 * 4) 스왑된 신규배열(copyOf)은 Depth를 증가시켜 다시 Perm 함수에 넣음.
	 * 5) Depth가 last index와 같다면 재귀를 종료하며, 현재 배열을 출력.(또는 전역변수에 넣거나...)
	 * 6) 결과 순열들이 정렬되지 않는다는 단점은 있다.
	 */
	public static void main(String[] args) {
		System.out.println("---start---");
		Permutation1 sol = new Permutation1();
		
		int[] param = new int[] {1,2,3};
		sol.perm(param, 0);
		
	}
	
	public void perm(int[] param, int depth) {
				
		for(int q=depth; q<param.length; q++) {
			System.out.println("call["+order+++"], depth["+depth+"], q["+q+"]");
			int[] child = Arrays.copyOf(param, param.length);
			
			//int[] child = param; //이런 식으로 생성하면 배열 공유됨.	
			
			swap(child, depth, q);
			
			perm(child, depth+1);
		}
		
		//depth가 배열의 마지막 index에 도달하면 print후 종료.
		if(depth == param.length) {
			printArr(param);
			return;
		}
	}
	
	public void swap(int[] arr, int idxA, int idxB) {
		int temp = arr[idxA];
		arr[idxA] = arr[idxB];
		arr[idxB] = temp;
	}
	
	public void printArr(int[] arr) {
		System.out.print("{" + arr[0]);
		for(int i=1; i<arr.length; i++) {
			System.out.print(", " + arr[i]);
		}
		System.out.println("}");
	}
}
