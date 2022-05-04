package programmers;

//import java.util.*;

//아메바 분열
//28042022

public class p28042022 {

    public static void main(String[] args) throws Exception {

        Solution105 s = new Solution105();

        int a = 2;

        int b = 5;

        System.out.println(s.solution(a, b));

    }
}

class Solution105 {

    public int solution(int delay, int N) {

        int[] sum = new int[100];
        int[] total = new int[100];

        sum[0] = 1;
        total[0] = 1;
        sum[1] = 2;
        total[1] = 3;
        sum[1 + 1 + delay] += 2;

        for (int i = 2; i <= N; i++) {
            sum[i] += (sum[i - 1] / 2) * 2;
            sum[i + (delay + 1)] += sum[i] / 2 * 2;
    
            total[i] = total[i - 1] + sum[i];
        }

        int answer = total[N];
        return answer;
    }
}