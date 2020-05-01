package com.arabica.pgms;

	import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExhSearch2 {

	//순열을 최종 저장하기 위해 전역변수 하나쓴다...
	Map<Integer, Integer> numList;
	
	public static void main(String[] args) {
		System.out.println("---start---");
		ExhSearch2 sol = new ExhSearch2();
		
		String param = "1234";
		
		int result = sol.solution(param);
		System.out.println("  ");
		System.out.println("result: " + result);
	}
	
	
	/**
	 * 2020-04-26 프로그래머스 문제 풀이
	 * 완전탐색 (소수 찾기)
	 * 
	 * 1) 소수를 구할땐, 에라토스테네스의 체를 이용.
	 * 2) 가능한 숫자의 조합을 모두 구하는 방법은? 순서가 중요하니 순열이용.
	 * 3) HashMap의 key는 자동정렬인줄 알았는데... 아닌가?
	 * 4) 순열을 구하는 방법은 다시 생각해본다.
	 * 
	 * @date 2020-05-01 완료.
	 */
	public int solution(String numbers) {
		int answer = 0;
        
        //순열을 저장할 목록
        numList = new HashMap<Integer, Integer>();
        
        //입력된 문자열 분리
        String[] strArr = numbers.split("");
        int n = strArr.length;

        //순열 구하기 (길이(r)가 1부터 n까지 늘어나는 모든 조합을 구하도록 반복.
        for(int r=1; r<=n; r++) {
        	permutation(strArr, 0, n, r);
        }        
                     
        int maxKey = 0;
        Object[] keySet = numList.keySet().toArray();
        Arrays.sort(keySet);
        for(Object key: keySet) {
        	maxKey = (int) key; //에라토스 정리할 최대값을 구한다
        }
        
        //소수가 정리된 배열 구하기
        int[] primes = getEratos(maxKey);
        
        for(Integer key: numList.keySet()) {
        	if(key > 1 && primes[key] > 0)
        		answer++;
        }    
                
        return answer;
    }
	
	
	public int solution_sysout(String numbers) {
        int answer = 0;
        
        //순열을 저장할 목록
        numList = new HashMap<Integer, Integer>();
        
        //입력된 문자열 분리
        String[] strArr = numbers.split("");
        int n = strArr.length;

        //순열 구하기 (길이(r)가 1부터 n까지 늘어나는 모든 조합을 구하도록 반복.
        for(int r=1; r<=n; r++) {
        	permutation(strArr, 0, n, r);
        }        
                     
        int maxKey = 0;
        Object[] keySet = numList.keySet().toArray();
        Arrays.sort(keySet);
        for(Object key: keySet) {
        	System.out.println("numList Key : " + key);     
        	maxKey = (int) key; //에라토스 정리할 최대값을 구한다
        }
        
        //소수가 정리된 배열 구하기
        int[] primes = getEratos(maxKey);
        System.out.println("primes size: " + primes.length);
        
        for(Integer key: numList.keySet()) {
        	if(key > 1 && primes[key] > 0)
        		answer++;
        }    
                
        return answer;
    }
	
	//swap을 통해서 순열을 구하는 방식
	public void permutation(String[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public void swap(String[] arr, int depth, int i) {
    	String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
	
    //순열의 마지막 항목을 출력하고, HashMap에 저장함.
    public void print(String[] arr, int r) {
        StringBuilder bld = new StringBuilder();
    	for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
            bld.append(arr[i]);
    	}
        System.out.println();
        Integer temp = Integer.parseInt(bld.toString());
        numList.put(temp, 0);
    }
    
    public int[] getEratos(int max) {
    	int[] numArr = new int[max+1];
    	Arrays.fill(numArr, 1); //1로 남아있는 것들이 소수
    	
    	for(int i=2; i<=max; i++) {
    		if(numArr[i] == 0) continue;
    		
    		for(int j=i+i; j<=max; j+=i) { //i의 배수를 타고 최대값까지 진행
    			numArr[j] = 0;	//배수에 해당하는 값은 소수 아니므로 0으로 표시
    		}
    	}
    	
    	return numArr;
    }
}




