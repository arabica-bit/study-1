package com.arabica.pgms;

import java.util.ArrayList;
import java.util.List;

public class Bfs1 {
	
	public static void main(String[] args) {
		
		System.out.println("#----------------------#");
		Bfs1 sol = new Bfs1();
		
		//Params
		String begin = "hit";
		String target = "hhh";
		//String[] words = new String[] {"hot", "dot", "dog", "lot", "log", "cog"}; //cog정답4
		//String[] words = new String[] {"hot", "dot", "dog", "lot", "log"}; //cog정답0
		//String[] words = new String[] {"hot", "dot", "wow", "lot", "pig", "cog"}; //cog정답0
		String[] words = new String[] {"hhh", "hht"}; //hhh정답2  --> 모든 대상을 보도록 해야하는구만.
		
		
		int result = sol.solution_sysout(begin, target, words);
		System.out.println("result: " + result);
		
	}
	
	/**
	 * 2020-06-07 프로그래머스 연습문제
	 * 깊이/너비 우선탐색 - 단어변환
	 * 
	 * 0) 알파벳 하나씩만 변경하여, target에 도달하는 방법 중 최단 거리를 찾는 문제.
	 * 0) 너비 우선 탐색으로 풀려고 했지만, 막상 풀고보니 DFS를 적용한 것 같다. 
	 *    원래는 재귀함수 안쓰고, Queue를 이용하는게 이 문제의 목표라고 생각됨.
	 * 
	 * -내가 푼 방법-  
	 * 1)주어진 단어 List. 항목 하나씩을 살펴보고 해당 항목이 target이 아니면 다음 단계(depth+1)로 이동.
	 * 2)다음 단계 넘어갈 때 새로운 List를 전달. 이 때 현재 확인한 단어(word)는 remove하고 전달해야 함. 
	 * 3)List의 남은 항목 중 변환 가능한 단어를 추리면서, 이 단어가 target과 일치하는지 확인. 동일하면 현재 depth를 리턴.  
	 * 4)for loop에서 List항목을 다 조회하고, 가장 작은 depth를 반환. 
	 * 5)만약 결과가 최초List의 크기보다 크다면, target에 도달 가능한 경로가 없다는 뜻이다. 즉, 0을 리턴하여 종료.
	 * 
	 * 6)처음에 순차 조회하는 방식으로 접근해서 삽질을 많이함. 순차 조회하면 위 "hhh", "hht" 케이스를 통과하지 못한다.
	 * 7)LinkedList를 해도 풀 수 있을것 같은데.. 나중에 복습할 기회가 있다면 시도해보자. 	 
	 * 
	 * @date 2020-06-07 완료.
	 */
	public int solution_sysout(String begin, String target, String[] words) {
        int answer = 0;
        List<String> wordList = new ArrayList<String>();
        for(int i=0; i<words.length; i++) {
        	wordList.add(words[i]);
        	if(target.equals(words[i])) answer = -1;
        }
              
        //words에 target이 포함되지 않았다면 리턴 0.
        if(answer != -1) return 0;
        
        int depth = 1;
        int min = 100;
        for(int q=0; q<wordList.size(); q++) {
        	String t = wordList.get(q);
        	if(getDiff(begin, t) == 1) {
        		if(target.equals(t)) {
        			//변환 가능한 대상이 target이면 리턴.
        			return depth;
        		}else {
        			List<String> newWord = new ArrayList<String>(wordList);
        			newWord.remove(q);
        			int result = bfs(newWord, depth, t, target);        		
            		if(result > 0 && result < min) min = result;
        		}
        	}
        }

        //다 돌았어도 해답이 없으면 min은 100일것이다.
        if(min > words.length) min = 0;
        return min;
    }	
	
	
	public int bfs(List<String> input, int depth, String word, String target) {		
		depth++;
		System.out.println("Depth["+depth+"], word["+word+"], ListSize["+input.size()+"]");
		int min = 100;		
		for(int q=0; q<input.size(); q++) {
			String t = input.get(q);			
			if(getDiff(word, t) == 1) {
				if(target.equals(t)) {
					System.out.println("return - Depth["+depth+"], target["+target+"], word["+word+"], ListSize["+input.size()+"]");
					return depth;
				}else {
					List<String> newWord = new ArrayList<String>(input);
					newWord.remove(q);
					int result = bfs(newWord, depth, t, target);
					if(result > 0 && result < min) min = result;
				}				
			}
		}
		
		return min;
	}
	
	public int getDiff(String base, String another) {
		int diff = 0;
		int leng = base.length();
		for(int k=0; k<leng; k++) {
			 if(base.charAt(k)-another.charAt(k) != 0) diff++;		
		}
		return diff;
	}
	
}
