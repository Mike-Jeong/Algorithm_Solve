package programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//import java.util.*;

//프랜즈4블록
//11052022

public class p11052022 {

    public static void main(String[] args) throws Exception {

        Solution109 s = new Solution109();

        int a = 4;
        int b = 5;

        String[] c = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

        System.out.println(s.solution(a, b, c));

    }
}

class Solution109 {

    char[][] board = new char[31][31];
    boolean[][] visited = new boolean[31][31];
    int[] idx_1 = {0, 1, 1};
    int[] idx_2 = {1, 1, 0};

    public int erase_block(final int m, final int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(new Pointer(i, j), m, n);
            }
        }

        int eraseCnt = 0;

        // erase block count
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    eraseCnt++;
                    board[i][j] = 'X';
                }
            }
        }
        return eraseCnt;
    }

    public void check(Pointer pos, int m, int n) {
        int cnt = 1;
        char ch = board[pos.idx1][pos.idx2];

        if(ch == 'X') return; 
        
        for (int i = 0; i < 3; i++) {
            Pointer next_ptr = new Pointer(pos.idx1 + idx_1[i], pos.idx2 + idx_2[i]);

            if (next_ptr.idx1 < 0 || next_ptr.idx1 > m || next_ptr.idx2 < 0 || next_ptr.idx2 > n) {
                continue;
            }

            char next_ch = board[next_ptr.idx1][next_ptr.idx2];

            if (next_ch == 'X') {
                continue;
            }

            if (next_ch != ch) {
                break;
            } else {
                cnt++;
            }
        }

        if (cnt == 4) {
            visited[pos.idx1][pos.idx2] = true;

            for (int i = 0; i < 3; i++) {
                Pointer next_ptr = new Pointer(pos.idx1 + idx_1[i], pos.idx2 + idx_2[i]);
                visited[next_ptr.idx1][next_ptr.idx2] = true;
            }
        }
    }

       public void downBlock(int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                int cur_ptr = j;

                while (cur_ptr >= 0 && board[cur_ptr][i] != 'X') {
                    cur_ptr -= 1;
                }

                if (cur_ptr < 0) {
                    continue;
                }

                if (cur_ptr == 0 && board[cur_ptr][i] != 'X') {
                    continue;
                }

                int next_ptr = cur_ptr - 1;

                while (next_ptr >= 0 && board[next_ptr][i] == 'X') {
                    next_ptr -= 1;
                }

                if (next_ptr < 0) {
                    continue;
                }

                board[cur_ptr][i] = board[next_ptr][i];
                board[next_ptr][i] = 'X';
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.board[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            int erasedBlock = erase_block(m, n);

            if (erasedBlock == 0) {
                break;
            }
            // down block
            downBlock(m, n);
            answer += erasedBlock;
            visited = new boolean[31][31];
        }
        return answer;
    }

    class Pointer {
        int idx1;
        int idx2;

        Pointer() {
        }

        public Pointer(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
        }
    }
}