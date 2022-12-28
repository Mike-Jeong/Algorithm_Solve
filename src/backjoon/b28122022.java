package backjoon;

import java.io.*;
import java.util.*;

//앱
//28122022

public class b28122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] apps  = new int[n + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			apps[i][0] = Integer.parseInt(st.nextToken());
		}

		int maxMemory = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			apps[i][1] = Integer.parseInt(st.nextToken());
			maxMemory += apps[i][1];
		}

		int[] dp = new int[maxMemory + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = maxMemory; j >= apps[i][1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - apps[i][1]] + apps[i][0]);
			}

			/*System.out.println("현재 : " + i + ", " + apps[i][0] + " " + apps[i][1]);
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[j] + " ");
			}

			System.out.println("\n");*/
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] >= m) {
				System.out.println(i);
				break;
			}
		}

	}

}