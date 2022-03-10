package programmers;

//import java.util.*;

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

        for (int i = 0; i < arr1.length; i++) {
           for (int j = 0; j < arr2[0].length; j++) {
               int sum = 0;
               for (int l = 0; l < arr1[0].length; l++) {
                   sum += (arr1[i][l] * arr2[l][j]);
               }
               answer[i][j] = sum;
           }
        }

        return answer;
    }
}