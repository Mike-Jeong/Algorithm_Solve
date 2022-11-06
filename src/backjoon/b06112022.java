package backjoon;

import java.io.*;
import java.util.*;

//테트로미노
//06112022

public class b06112022 {

	static int[][] map;
	static boolean[][] visited;
	static int ans = 0;
	static int[] rowOrder = new int[] { -1, 0, 1, 0 };
	static int[] colOrder = new int[] { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				recursion(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(ans);
	}

	public static void recursion(int x, int y, int count, int sum) {

		if (count == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			try {
				if (!visited[x + rowOrder[i]][y + colOrder[i]]) {

					if (count == 2) {
						visited[x + rowOrder[i]][y + colOrder[i]] = true;
						recursion(x, y, count + 1, sum + map[x + rowOrder[i]][y + colOrder[i]]);
						visited[x + rowOrder[i]][y + colOrder[i]] = false;
					}
					visited[x + rowOrder[i]][y + colOrder[i]] = true;
					recursion(x + rowOrder[i], y + colOrder[i], count + 1, sum + map[x + rowOrder[i]][y + colOrder[i]]);
					visited[x + rowOrder[i]][y + colOrder[i]] = false;
				}
			} catch (Exception e) {
				continue;
			}
		}

	}
}
