package com.arabica.basic;

public class MutableTest {
	
	/**
	 * Mutable Class, Immutable Class 실험.
	 * 이와 관련된 Interning과 Flyweight 패턴에 대해 간략히 실험.
	 */
	public static void main(String[] args) {
		System.out.println("----start-----");

		//서로 다른 메모리에 할당되도록 함.
		String stringValue1 = "TEST";
		String stringValue2 = "TEST";
		
		System.out.println("stringValue1 Hash[" + System.identityHashCode(stringValue1) + "]");
		System.out.println("stringValue2 Hash[" + System.identityHashCode(stringValue2) + "]");
		//이론상 위의 두 객체는 다른 코드를 출력해야 하는데 동일함을 확인할 수 있다. 왜 그럴까?
		
		/*
		 * 자바는 리터럴을 상수 풀(constant pool)에 보관한다.
		 * 그리고 String은 풀 안의 같은 상수를 참조하는데, 이를 String 인터닝(interning)이라고 한다.
		 * Interning은 상수 풀안에 있는 대상을 참조할 수 있도록 한다.
		 * 
		 * 명시적으로 'String.intern()' 메소드를 이용하면, 
		 * String Pool에서 해당하는 상수를 찾아 반환한다. 없으면 새로 Pool에 추가하고 반환해준다.
		 * 
		 * String은 자동적으로 이러한 방법이 적용된 것을 알 수 있다.
		 * 이 String Pool은 플라이웨이트 패턴의 대표적인 구현체 이다. (자세한 것은 에버노트)
		 */
		String stringValue3 = stringValue1.intern();
		System.out.println("stringValue3 Hash[" + System.identityHashCode(stringValue3) + "]");
		
		
		//이 경우 4번, 5번은 값은 같지만 서로 다른 메모리에 저장된다.
		String stringValue4 = stringValue1 + "1";
		String stringValue5 = stringValue2 + "1";
		System.out.println("stringValue4 Hash[" + System.identityHashCode(stringValue4) + "]");
		System.out.println("stringValue5 Hash[" + System.identityHashCode(stringValue5) + "]");
		
		
		//StringBuffer는 Mutable 클래스이며, 상태를 변경해도 메모리에 Append되므로 참조가 변하지 않는다.
		StringBuffer sBuf1 = new StringBuffer();
		sBuf1.append("step1");
		System.out.println("sBuf1 Hash[" + System.identityHashCode(sBuf1) + "]");
		sBuf1.append("step2");
		System.out.println("sBuf1 Hash[" + System.identityHashCode(sBuf1) + "]");
		sBuf1.append("step3");
		System.out.println("sBuf1 Hash[" + System.identityHashCode(sBuf1) + "]");
		//StringBuilder도 동일하다.
		StringBuilder sBil1 = new StringBuilder();
		sBil1.append("check 1");
		System.out.println("sBuilder1 Hash[" + System.identityHashCode(sBil1) + "]");
		sBil1.append("check 2");
		System.out.println("sBuilder1 Hash[" + System.identityHashCode(sBil1) + "]");
		sBil1.append("check 3");
		System.out.println("sBuilder1 Hash[" + System.identityHashCode(sBil1) + "]");
		//-- 여기까지 mutable/immutable 실험.
		
		
		
		//그렇다면 StringBuilder와 StringBuffer는 같은 동작인데 서로 다른 클래스로 구현되어있을까?
		MutableTest mut = new MutableTest();
		mut.diffOfMutable();
	}
	
	
	public void diffOfMutable() {
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();

		new Thread(() -> {
		    for(int i=0; i<10000; i++) {
		        stringBuffer.append(i);
		        stringBuilder.append(i);
		    }
		}).start();

		new Thread(() -> {
		    for(int i=0; i<10000; i++) {
		        stringBuffer.append(i);
		        stringBuilder.append(i);
		    }
		}).start();

		new Thread(() -> {
		    try {
		        Thread.sleep(5000);

		        System.out.println("StringBuffer.length: "+ stringBuffer.length());
		        System.out.println("StringBuilder.length: "+ stringBuilder.length());
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}).start();

		
		/*
		 * 이 함수를 돌렸을 때, 결과는 아래와 같다.
		 * 	StringBuffer.length: 77780
		 *	StringBuilder.length: 74273
		 * *Buffer는 멀티 쓰레드 환경에서 sync를 보장한다. 한 쓰레드가 붙으면 다른 쓰레드는 붙을 수 없기 때문에
		 *  중복된 값 없이 순차적으로 값이 더해졌다.
		 * *그러나 Builder는 멀티 쓰레드 환경에서 여러 쓰레드가 동시에 해당 객체에 접근할 수 있다.
		 *  그래서 여러 쓰레드가 같은 값을 이어 붙였을 것이기 때문에, 더 짧을 것이다.
		 * 더 명확한 예제가 있을 수 있으나 내가 찾은 자료에서는 이렇게 비교했다.
		 */
		

	}

}
