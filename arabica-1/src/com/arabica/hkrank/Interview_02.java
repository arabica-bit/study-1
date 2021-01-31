import java.io.*;

/**
 * Practice -> Interview Preparation Kit
 * Warm-up Challenges 02: Counting Valleys
 *
 * 주어진 입력에서 몇 개의 밸리(골짜기)를 지났는지 찾기.
 * 밸리의 정의가 높이 0에서 -1로 진입하고, 최종적으로 0에 도달해야 하나의 밸리로 계산한다는 점만 생각하면 된다.
 * 쉬운 난이도인 만큼 처리시간은 고민하지 않아도 됨.
 */
 public class Interview_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sjtext.txt"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int prev = 0;
        int numOfValley = 0;

        String[] paths = path.split("");
        for(int i=0; i<paths.length; i++){
            if(paths[i].equals("D")){
                if(prev==0) numOfValley++;
                prev -= 1;
            }else{
                prev += 1;
            }
        }

        System.out.println(numOfValley);
        return numOfValley;
    }

}
