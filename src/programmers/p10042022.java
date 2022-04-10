package programmers;

import java.util.*;

//사라지는 발판
//10042022

public class p10042022 {

    public static void main(String[] args) throws Exception {

        Solution101 s = new Solution101();

        int a = 2;
        int b = 9;
    
        System.out.println(s.solution(a, b));

    }
}

class Solution101 {

    public int[] solution(int n, int s) {

        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = {};
        return answer;
    }
}