package com.arabica.pgms;

public class ExhSearch3 {

	public static void main(String[] args) {
		System.out.println("---start---");
		ExhSearch3 sol = new ExhSearch3();
	
		int _brown = 24;
		int _red = 24;
		
		int[] result = sol.solution(_brown, _red);
		System.out.println("---result---");
		for(int i : result) {
			System.out.println(i);
		}
		
	}
	
	/**
	 * 2020-05-10 프로그래머스 문제 풀이
	 * 완전 탐색 (카펫)
	 * 
	 * 1) 엑셀이나 연습장에 그림을 그리면 쉽게 이해할 수 있다.
	 * 2) 사각형 넓이는 red의 개수와 같고, (모서리4개블록을제외한)둘레는 brown의 개수와 같다고 생각하면 됨.
	 * 3) red=h*v이고, brown=(h+v)*2+4를 정하여 h와 v를 찾으면 끝.
	 * 
	 * @date 2020-05-10 완료.
	 */
	public int[] solution_sysout(int brown, int red) {
        int[] answer = {0,0};
        
        for(int v=1; v<=red; v++) {
        	System.out.println("v["+v+"], red%v["+red%v+"] ");
        	if(red%v != 0) continue;
        	
        	int h = red/v;
        	
        	Integer bBlock = (h+v)*2 + 4;
        	System.out.println("bBlock: " + bBlock);
        	//답을 찾는 순간 멈출거니까, v가 h보다 길어지기 전에 루프는 끝난다.
        	if(bBlock.equals(brown)) {
        		answer[0] = h+2; //모서리 길이 포함
        		answer[1] = v+2;
        		return answer;
        	}
        	
        }
        
        return answer;
    }
	
	
	public int[] solution(int brown, int red) {
        int[] answer = {0,0};
        
        for(int v=1; v<=red; v++) {
        	if(red%v != 0) continue;
        	
        	int h = red/v;
        	
        	Integer bBlock = (h+v)*2 + 4;
        	if(bBlock.equals(brown)) {
        		answer[0] = h+2;
        		answer[1] = v+2;
        		return answer;
        	}
        	
        }
        
        return answer;
    }
}
