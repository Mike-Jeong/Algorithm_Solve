package programmers;

import java.util.*;

//두 정수 사이의 합
//02022022

public class p02022022 {
    public static void main(String[] args) throws Exception {
        Solution34 s = new Solution34();
        int a = 3; // 12
        int b = 5;
        System.out.println(s.solution(a, b));

    }
}

class Solution34 {

    public long solution(int a, int b) {
        long answer = 0;

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }
        
        return answer;
    }
}