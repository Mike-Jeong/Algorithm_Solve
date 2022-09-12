package backjoon;

import java.io.*;
import java.util.*;

//Coins
//12092022

public class b12092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int[] coins = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				coins[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());

			int[] dp = new int[target + 1];

			dp[0] = 1;

			for (int j = 0; j < n; j++) {
				for (int j2 = 1; j2 <= target; j2++) {
					if (j2 - coins[j] >= 0) {
						dp[j2] += dp[j2 - coins[j]];
					}
				}
			}

			System.out.println(dp[target]);
		}
	}
}