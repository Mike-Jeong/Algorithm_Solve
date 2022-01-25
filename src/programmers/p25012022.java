package programmers;

import java.util.*;

//최소직사각형
//25012022

public class p25012022 {
    public static void main(String[] args) throws Exception {
        Solution26 s = new Solution26();

        int[][] a = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};


        System.out.println(s.solution(a));

    }
}

class Solution26 {

    public int solution(int[][] sizes) {

        int length_a = 0;
        int length_b = 0;

        for (int[] is : sizes) {
            
            Arrays.sort(is);

           length_a = Math.max(length_a, is[0]);
           length_b = Math.max(length_b, is[1]);

        }
        
        int answer = length_a * length_b;
        return answer;
    }
}