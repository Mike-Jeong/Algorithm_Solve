package backjoon;

import java.util.*;
import java.io.*;

public class b03042022 {
    public static char[][] board;
    public static boolean[][] visited;
    public static int result = 0;
    public static int[] row_order = {-1, 0, 1, 0};
    public static int[] col_order = {0 ,-1, 0, 1};
    public static Set<Character> ck = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
        visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

        dfs(0, 0, 0);

        System.out.println(result);
    }

    public static void dfs(int count, int row, int col) {
        
        visited[row][col] = true;
        count++;
        ck.add(board[row][col]);

        for (int i = 0; i < 4; i++) {
            try {
                if (!visited[row + row_order[i]][col + col_order[i]] && !ck.contains(board[row + row_order[i]][col + col_order[i]])) {
                  dfs(count, row + row_order[i], col + col_order[i]);   
                }

            } catch (Exception e) {
                continue;
            }
        }

        ck.remove(board[row][col]);
        visited[row][col] = false;

        result = Math.max(result, count);
    }
}
