package programmers;

import java.util.*;

//최고의 집합
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
        if(n > s)
            return new int[]{-1};
        
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++)
            answer[i] = s/n;
  
        for(int i=0; i<s%n; i++)
            answer[i] ++;
        
        Arrays.sort(answer);
        
        return answer;
    }
  }