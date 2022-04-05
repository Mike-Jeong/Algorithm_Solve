package programmers;

import java.util.*;

//야근 지수
//05042022

public class p05042022 {

    public static void main(String[] args) throws Exception {

        Solution98 s = new Solution98();

        int a = 4;

        int[] b = { 4, 3, 3 };

        System.out.println(s.solution(a, b));

    }
}

class Solution98 {

    public long solution(int n, int[] works) {

        PriorityQueue<Integer> times = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer integer : works) {
            times.add(integer);
        }

        while (n > 0) {
            int ck = times.poll();
            if (ck <= 0) {
                return 0;
            }
            times.add(ck - 1);
            n -= 1;    
        }

        long answer = 0;

        for (Integer integer : times) {
            answer += (integer * integer);    
        }
     
        return answer;
    }
}