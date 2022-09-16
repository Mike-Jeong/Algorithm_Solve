package backjoon;

import java.io.*;
import java.util.*;

//포도주 시식
//16092022

public class b16092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());

		int[] wines = new int[n];

		for (int i = 0; i < wines.length; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n];
		dp[0] = wines[0];

		for (int i = 1; i < n; i++) {

			if (i == 1) {
				dp[1] = wines[0] + wines[1];
				continue;
			}

			if (i == 2) {
				dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));
				continue;
			}
			
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
		}

		System.out.println(dp[n - 1]);
	}
}