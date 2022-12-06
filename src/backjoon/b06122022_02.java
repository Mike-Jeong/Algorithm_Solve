package backjoon;

import java.io.*;
import java.util.*;

//1로 만들기 2
//06122022

public class b06122022_02 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] dp = new int[n + 1];
		int[] routes = new int[n + 1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {

			dp[i] = dp[i - 1] + 1;
			routes[i] = i - 1;

			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				routes[i] = i / 3;
			}

			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				routes[i] = i / 2;
			}

		}

		System.out.println(dp[n]);

		while (n > 0) {
			System.out.print(n + " ");
			n = routes[n];
		}

	}
}