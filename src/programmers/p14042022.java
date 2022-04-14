package programmers;

import java.util.*;

//ㄷ자 모양 채우기
//14

public class p14042022 {

    public static void main(String[] args) throws Exception {

        Solution103 s = new Solution103();

        int a = 4;
        int b = 1;
        int c = 3;

        System.out.println(s.solution(a, b, c));

    }
}

class Solution103 {

    int[][] board;
    int count = 1;
    int[] row_order = { 0, 0, 1, 1 };
    int[] col_order = { 0, -1, -1, 0 };
    int target_r;
    int target_c;

    public int solution(int n, int i, int j) {

        board = new int[n][n];

        target_r = i;
        target_c = j;

        fill_board(n, 0, n - 1);

        int answer = board[i][j];
        return answer;
    }

    public boolean fill_board(int n, int x, int y) {

        if (n == 2) {
            for (int i = 0; i < 4; i++) {

                board[x + row_order[i]][y + col_order[i]] = count;

                if ((x + row_order[i]) == target_r && (y + col_order[i]) == target_c) {
                    return true;
                }
                count++;
            }
            return false;

        } else {

            if (fill_board(n / 2, x + 0, y + 0)) {
                return true;
            } else if (fill_board(n / 2, x + 0, y + (-n / 2))) {
                return true;
            } else if (fill_board(n / 2, x + (n / 2), y + (-n / 2))) {
                return true;
            } else if (fill_board(n / 2, x + (n / 2), y + 0)) {
                return true;
            }
            return false;
        }
    }
}// 효율성이 안나옴.....


/*
class Solution {
    int[][] board;
    int count = 1;
    int[] row_order = { 0, 0, 1, 1 };
    int[] col_order = { 0, -1, -1, 0 };

    public int solution(int n, int i, int j) {

        board = new int[n][n];

        fill_board(n, 0, n - 1);

        int answer = board[i][j];
        return answer;
    }

    public void fill_board(int n, int x, int y) {

        if (n == 2) {
            for (int i = 0; i < 4; i++) {
                board[x + row_order[i]][y + col_order[i]] = count;
                count++;
            }
            return;
        }

        fill_board(n / 2, x + 0, y + 0);
        fill_board(n / 2, x + 0, y + (-n / 2));
        fill_board(n / 2, x + (n / 2), y + (-n / 2));
        fill_board(n / 2, x + (n / 2), y + 0);

    }
}
*/