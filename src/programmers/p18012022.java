package programmers;

import java.util.*;

//예산
//18012022

public class p18012022 {
    public static void main(String[] args) throws Exception {
        Solution20 s = new Solution20();

        int[] a = {2,2,3,3};
        int b = 10;

        System.out.println(s.solution(a,b));
        
    }
}

class Solution20 {

    public int solution(int[] d, int budget) {

        Arrays.sort(d);

        int sum = 0;
        int answer = 0;

        while (true) {
            sum += d[answer];
            if (sum >= budget) {
                if (sum == budget) {
                    answer++;
                }
                break;
            }
            answer++;
            if (answer == d.length) {
                break;
            }
        }
        
        return answer;
    }
}
