package com.arabica.hkrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Practice -> Interview Preparation Kit
 * Warm-up Challenges 03: Jumping on the Clouds
 *
 * 배열의 처음(인덱스0)부터 끝까지 이동하기 위해 최소한 몇번 점프해야 하는가?
 * 인덱스 이동(점프)는 +1 또는 +2 가능하며, 값이 1인곳은 피해서 점프해야 하므로 +2를 해야 함.
 *
 * 주의사항: 변수 사용해야 할 때는 충분히 사용한다. 변수 하나 줄이자고 코드 복잡하게 만들면 결국 실패함.
 */
public class Interview_03 {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jump = 0;
        int prev = 0; //직전 값
        int hold = 0; //최대 점프 수는 +2. '0 0 0' 인 경우 점프 한번으로 이동가능하다.
        for(int i=1; i<c.length; i++){
            if(c[i]==1){
                jump += 1;
                if(hold > 0) jump +=1;
                prev = 1;
                hold = 0;
            }else if(hold>0) {
                //1번 hold 한 경우, jump 해야 함. 마지막 인덱스인 경우에도 차이없음.
                jump +=1;
                hold = 0;
                prev = 0;
            }else{
                //직전 1이었거나, hold 1번 다 채운 경우에 해당.
                if(prev != 1) hold++;

                //마지막 인덱스인 경우, 직전 값이 1이 아니었다면 남은 hold 더해준다.
                if(i==c.length-1) jump += hold;

                //var 갱신
                prev = 0;
            }
        }

        System.out.println(jump);
        return jump;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sjtext.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
