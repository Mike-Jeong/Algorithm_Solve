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

        int[][] board_c = new int[board.length + 1][board[0].length + 1];

        for (int[] is : skill) {
            if (is[0] == 1) {
                board_c[is[1]][is[2]] += - is[5];
                board_c[is[3] + 1][is[4] + 1] += - is[5];
                board_c[is[1]][is[4] + 1] += is[5];
                board_c[is[3] + 1][is[2]] += is[5];
            } else {
                board_c[is[1]][is[2]] += is[5];
                board_c[is[3] + 1][is[4] + 1] += is[5];
                board_c[is[1]][is[4] + 1] += - is[5];
                board_c[is[3] + 1][is[2]] += - is[5];
            }
           
        }

        for (int i = 0; i < board_c[0].length; i++) {
            for (int j = 1; j < board_c.length; j++) {
                board_c[j][i] += board_c[j - 1][i];
            }
        }

        for (int i = 0; i < board_c.length; i++) {
            for (int j = 1; j < board_c[0].length; j++) {
                board_c[i][j] += board_c[i][j - 1];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += board_c[i][j];

                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}