package backjoon;

import java.io.*;
import java.util.*;

//퇴사 2
//25092022

public class b25092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] times = new int[n + 1];
		int[] prices = new int[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			prices[i] = Integer.parseInt(st.nextToken());			
		}

		int[] dp = new int[n + 1];
		int max = 0;

		for (int i = 0; i <= n; i++) {

			max = Math.max(max, dp[i]);

			int next = i + times[i];
			
			if (next <= n) {
				dp[next] = Math.max(dp[next], max + prices[i]);
			}  
		}

		System.out.println(max);
	}
}