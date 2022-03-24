package programmers;

import java.util.*;

//피로도
//25032022

public class p25032022 {

    public static void main(String[] args) throws Exception {

        Solution90 s = new Solution90();

        int[][] a = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };

        System.out.println(s.solution(a));

    }
}

class Solution90 {

    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    int[][] board;
    int[] row_order = { 0, 1, 1 };
    int[] col_order = { 1, 1, 0 };
    int ans = 0;

    public int solution(int[][] board) {

        this.board = board;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[] { i, j });
                    int count = 0;

                    while (!queue.isEmpty()) {

                        int[] now = queue.poll();
                        if (!visited[now[0]][now[1]]) {
                            count++;
                            bfs(now[0], now[1]);
                        }

                    }

                    ans = Math.max(count, ans);
                }
            }
        }
        return ans;
    }

    public void bfs(int r, int c) {

        visited[r][c] = true;

        LinkedList<int[]> ck = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            try {
                if (!visited[r + row_order[i]][c + col_order[i]]) {
                    if (board[r + row_order[i]][c + col_order[i]] != 1) {
                        return;
                    }
                    ck.add(new int[] { r + row_order[i], c + col_order[i] });
                }

            } catch (Exception e) {
                return;
            }
        }

        queue.addAll(ck);

    }
}