package backjoon;

import java.io.*;
import java.util.*;

//수도배관공사
//27122022

public class b27122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] pipes  = new int[m + 1][2];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			pipes[i][0] = Integer.parseInt(st.nextToken());
			pipes[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		dp[0] = Integer.MAX_VALUE;

		for (int i = 1; i <= m; i++) {
			for (int j = n; j >= pipes[i][0]; j--) {
				dp[j] = Math.max(dp[j], Math.min(pipes[i][1], dp[j - pipes[i][0]]));
			}

			/*System.out.println("현재 : " + i + ", " + pipes[i][0] + " " + pipes[i][1]);
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[j] + " ");
			}

			System.out.println("\n");*/
		}

		System.out.println(dp[n]);

	}

}