package backjoon;

import java.io.*;
import java.util.*;

//숫자고르기
//23112022

public class b23112022 {

	static char[][] map;
	static boolean[][] visited;

	static int[] rowOrder = new int[] { -1, 0, 1, 0 };
	static int[] colOrder = new int[] { 0, 1, 0, -1 };

	static Stack<int[]> endpoints = new Stack<>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {

			String s = br.readLine();

			for (int j = 0; j < m; j++) {

				map[i][j] = s.charAt(j) == '.' ? '@' : '+';

				if (map[i][j] == '@' && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
					endpoints.push(new int[] { i, j });
				}

			}
		}

		int[] start = endpoints.pop();
		recursion(start[0], start[1]);
	}

	static boolean recursion(int row, int col) {

		visited[row][col] = true;

		if (row == endpoints.peek()[0] && col == endpoints.peek()[1]) {
            
            map[row][col] = '.';
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < map.length; i++) {
				sb.append(map[i]);
				sb.append("\n");
			}
			System.out.println(sb.toString());

			return true;
		}

		for (int i = 0; i < 4; i++) {
			try {
				if (!visited[row + rowOrder[i]][col + colOrder[i]]
						&& map[row + rowOrder[i]][col + colOrder[i]] == '@') {

					map[row][col] = '.';
					if (recursion(row + rowOrder[i], col + colOrder[i])) {
						return true;
					}
					map[row][col] = '@';
				}
			} catch (Exception e) {
				continue;
			}
		}

		return false;
	}
}