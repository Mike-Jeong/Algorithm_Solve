package backjoon;

import java.io.*;
import java.util.*;

//알고스팟
//02082022

public class b02082022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		int[] rowOrder = new int[] { -1, 0, 1, 0 };
		int[] colOrder = new int[] { 0, -1, 0, 1 };

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = (int) line.charAt(j) - 48;
				dp[i][j] = 1000000000;
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		dp[0][0] = 0;
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				try {
					if (map[now[0] + rowOrder[i]][now[1] + colOrder[i]] == 1) {
						if (dp[now[0] + rowOrder[i]][now[1] + colOrder[i]] > dp[now[0]][now[1]] + 1) {
							dp[now[0] + rowOrder[i]][now[1] + colOrder[i]] = dp[now[0]][now[1]] + 1;
							queue.add(new int[] { now[0] + rowOrder[i], now[1] + colOrder[i] });
						}
					} else {
						if (dp[now[0] + rowOrder[i]][now[1] + colOrder[i]] > dp[now[0]][now[1]]) {
							dp[now[0] + rowOrder[i]][now[1] + colOrder[i]] = dp[now[0]][now[1]];
							queue.add(new int[] { now[0] + rowOrder[i], now[1] + colOrder[i] });
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
		}

		System.out.println(dp[n - 1][m - 1]);
	}
}