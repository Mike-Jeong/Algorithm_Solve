package programmers;

//import java.util.*;

//파괴되지 않은 건물
//01042022

public class p01042022 {

    public static void main(String[] args) throws Exception {

        Solution96 s = new Solution96();

        int[][] a = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] b = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };

        System.out.println(s.solution(a, b));

    }
}

class Solution96 {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        return answer;
    }
}