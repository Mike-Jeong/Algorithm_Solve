package backjoon;

import java.io.*;
import java.util.*;

//내리막길
//18072022

public class b18072022 {

	static int n;
	static int m;
	static int[][] arr;
	static int[][] dp;
	static int[] rowOrder = { -1, 0, 1, 0 };
	static int[] colOrder = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(DFS(1, 1));
	}

	public static int DFS(int x, int y) {
		if (x == m && y == n) {
			return 1;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0; 
		for (int i = 0; i < 4; i++) {
			int dx = x + rowOrder[i];
			int dy = y + colOrder[i];

			if (dx < 1 || dy < 1 || dx > m || dy > n) {
				continue;
			}
			
			if (arr[x][y] > arr[dx][dy]) {
				dp[x][y] += DFS(dx, dy);
			}
		}

		return dp[x][y];
	}

}