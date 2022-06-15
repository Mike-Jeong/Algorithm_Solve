package backjoon;

import java.io.*;
//import java.util.*;

//달나라 토끼를 위한 구매대금 지불 도우미
//15062022

public class b15062022 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;

		for (int i = 8; i <= n; i++) {
			dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 2], Math.min(dp[i - 5], dp[i - 7]))) + 1;
		}

		System.out.print(dp[n]);

	}
}