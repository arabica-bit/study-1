package com.arabica.pgms;

public class BinarySearch1 {

    public static void main(String[] args) {
        System.out.println("#----------------------#");
        BinarySearch1 sol = new BinarySearch1();

        //Params
        int n = 6;
        int[] times = new int[]{7,10};

        long result = sol.solution(n, times);
        System.out.println("result: " + result);
    }

    /**
     * 2020-09-01 프로그래머스 연습문제
     * 이분탐색 - 입국심사
     *
     * 1) 최적의 시간을 탐색
     * 2) 입력 파라미터 n값 & times 배열 크기가 10억개까지이므로, long타입으로 처리해야 함.
     *      --> int로 처리하면 에러 혹은 시간초과 발생.
     * 3) 걸리는 시간중에서 최소값을 찾아야 한다.
     *      --> 샘플입력에서 똑같은 6명의 정답이 나오는 시간이 2개가 나올수 있다. (29초, 28초)
     *      --> 여기서 최소 시간을 찾아야 하는 것이다. 이 부분 처리가 완벽하지 않아서, 모든 케이스 실패했었다.
     * 4) 최소값을 찾기 위해서, (works==n)이 되어도 바로 루프를 중단해서는 안된다.
     *      --> (left<right) 될때까지 쭉 돌아야 한다.
     *
     * @date 2020-09-03 완료 
     */
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = (long)times[times.length-1] * (long)n;
        long mid;
        answer = right;

        while(right >= left) {
            mid = (left+right)/2;
            long works = getPassed(n,times, mid);
            System.out.println("left["+left+"], right["+right+"], mid["+mid+"], works["+
                    works+"], answer["+answer+"]");
            if(works >= n){
                if(mid<answer) answer = mid;
                right = mid-1;
            }else{
                //(works<n)
                left = mid+1;
            }
        }

        return answer;
    }

    public long getPassed(int n, int[] times, long period) {
        long total = 0;
        for(int t : times){
            long temp = period/(long)t;
            total+=temp;
            if(total > n) break;
        }
        return total;
    }


}
