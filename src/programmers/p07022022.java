package programmers;

import java.util.*;

//카카오 프렌즈 컬러링북
//07022022

public class p07022022 {
    public static void main(String[] args) throws Exception {
        Solution39 s = new Solution39();

        int a = 6;
        int b = 4;
        int[][] c = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(s.solution(a, b,c));
    }
}

class Solution39 {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}