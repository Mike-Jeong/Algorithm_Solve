package programmers;

import java.util.*;

//행렬의 곱셈
//01032022

public class p01032022 {
    public static void main(String[] args) throws Exception {

        Solution62 s = new Solution62();

        int[][] a = {{1, 4}, {3, 2}, {4, 1}};
        int[][] b = {{3, 3}, {3, 3}};

        System.out.println(s.solution(a,b));
    }
}

class Solution62 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
           for (int j = 0; j < answer[0].length; j++) {

           }
        }

        return answer;
    }
}