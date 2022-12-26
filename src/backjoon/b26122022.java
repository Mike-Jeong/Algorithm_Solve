package backjoon;

import java.io.*;
import java.util.*;

//개업 2
//26122022

public class b26122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] woks = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			woks[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, 987654321);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {

				if (i == j) {
					dp[woks[i]] = 1;
					continue;
				}

				if (woks[i] + woks[j] <= n) {
					dp[woks[i] + woks[j]] = 1;
				}

			}
		}

		for (int i = 1; i <= n; i++) {
			if (dp[i] == 1) {
				continue;
			}

			for (int j = 1; j <= i/2; j++) {
				if (dp[i - j] == -1 || dp[j] == -1) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
			}

			if (dp[i] == 987654321) {
				dp[i] = -1;
			}
		}

		System.out.println(dp[n]);

	}

}