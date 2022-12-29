package backjoon;

import java.io.*;
import java.util.*;

//사탕 가게
//29122022

public class b29122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine());

		while (true) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

			if (n == 0 && m == 0) {
				break;
			}

			int[][] candies = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				candies[i][0] = Integer.parseInt(st.nextToken());
				candies[i][1] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
			}

			int[] dp = new int[m + 1];

			for (int i = 0; i < n; i++) {

				if (candies[i][1] < m) {
					for (int j = candies[i][1]; j <= m; j++) {
						dp[j] = Math.max(dp[j], dp[j - candies[i][1]] + candies[i][0]);
					}
				}

				/*
				 * System.out.println("현재 : " + i + ", " + candies[i][0] + " " + candies[i][1]);
				 * for (int j = 0; j < dp.length; j+=100) {
				 * System.out.print(dp[j] + " ");
				 * }
				 * 
				 * System.out.println("\n");
				 */

			}

			System.out.println(dp[m]);

		}

	}

}