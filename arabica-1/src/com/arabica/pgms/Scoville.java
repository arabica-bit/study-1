package com.arabica.pgms;

public class Scoville {
	
	static int[] mArray;
	
	public static void main(String[] args) {
		
		System.out.println("scoville test");
		Scoville sc = new Scoville();
		
		int[] scoville = new int[] {1,2,3,9,10,12};
		System.out.println("hc result: " + sc.solution(scoville, 7));
		
		/**
		 * 채점 결과
		 * 정확성: 57.1
		 * 효율성: 0.0
		 * 합계: 57.1 / 100.0
		 * 실패.
		 */
	}
	
	private int solution(int[] scoville, int k) {
		int answer = 0;
		
		//put
		mArray = new int[scoville.length];
		for(int i=0; i<scoville.length; i++) {
			mArray[i] = scoville[i];		
			mSort(i);
		}
		System.out.println("-----Initial-------");
		printArray();
		
		
		//Last부터 kPos까지만 살펴보면 된다
		for(int i=scoville.length-1; i>0; i--) {
			int a = mArray[i];
			int b = mArray[i-1];
			
			if(a>k && b>k) break;
			if(b==0) return -1;
			
			System.out.println("Calc a[" + a + "], b[" + b + "].");
			int c = a + (b*2);
			answer++;
			mArray[i] = 0;
			mArray[i-1] = c;
			
			//계산 한번하면 다시 소팅
			mSort(i-1);
		}
		System.out.println("-----After Sort-------");
		printArray();
		
		return answer;
	}

	private void mSort(int pos) {
		//가장 마지막 자리에 있는 값을 0번 인덱스까지 정렬
		if(mArray.length < 1) return;
		
		//큰 값을 맨 앞으로. 작은 값은 뒤쪽에 남도록.
		for(int q=pos; q>0; q--) {
			
			if(mArray[q] > mArray[q-1]) {
				int temp=mArray[q];
				mArray[q] = mArray[q-1];
				mArray[q-1] = temp;				
			}else {	
				//정렬 할게 없으니 리턴
				break;
			}			
		}
		
		return;
	}
	
	private void printArray() {
		for(int w=0; w<mArray.length; w++) {
			System.out.println("list[" + w + "]: " + mArray[w]);
		}
	}

}
