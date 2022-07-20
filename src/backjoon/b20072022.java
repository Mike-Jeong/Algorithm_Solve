package backjoon;

import java.io.*;
import java.util.*;

//벼락치기
//20072022

public class b20072022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] section = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int expectTime = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			section[i][0] = expectTime;
			section[i][1] = score;
		}

		int[][] dp = new int[N + 1][T + 1];
		for (int i = 1; i <= N; i++) {
			int t = section[i][0];
			int score = section[i][1];
			for (int j = 1; j <= T; j++) {
				if (j >= t) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t] + score);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][T]);

	}
}