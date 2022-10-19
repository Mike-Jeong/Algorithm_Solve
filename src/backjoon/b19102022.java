package backjoon;

import java.io.*;
import java.util.*;

//자두나무
//19102022

public class b19102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[][] dp = new int[t + 1][w + 1];

		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int tree = Integer.parseInt(st.nextToken());

			for (int j = 0; j <= w; j++) {

				if (j == 0) {
					if (tree == 1)
						dp[i][j] = dp[i - 1][j] + 1;
					else
						dp[i][j] = dp[i - 1][j];

					continue;
				}

				if (j % 2 == 0) {
					if (tree == 1)
						dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
					else
						dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
				}

				else {
					if (tree == 1)
						dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
					else
						dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i <= w; i++) {
			ans = Math.max(ans, dp[t][i]);
		}

		System.out.println(ans);
	}

}