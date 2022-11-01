package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 바이토닉 부분 수열 (다시 풀기)
//01112022

public class b01112022_02 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int[] dp = new int[n];
		int[] dp_min = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());		
			
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {

			dp_min[i] = 0;

			for (int j = i + 1; j < n; j++) {
				if (nums[i] > nums[j]) {
					dp_min[i] = Math.max(dp_min[i], dp_min[j] + 1);
				}
			}

			dp[i] = dp[i] + dp_min[i];
		}

		int ans = 0;

		for (int i = 0; i < dp.length; i++) {
			ans = Math.max(dp[i], ans);
		}

		System.out.println(ans);

	}
}

