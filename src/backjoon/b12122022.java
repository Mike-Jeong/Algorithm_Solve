package backjoon;

import java.io.*;
import java.util.*;

//전깃줄
//12122022

public class b12122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] cable = new int[n + 1][2];
		int[] dp  = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			cable[i][0] = Integer.parseInt(st.nextToken());
			cable[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cable, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[0] - o2[0];
			}
			
		});

		int max = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (cable[j][1] < cable[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}

		System.out.println(n - max);

		/*for (int i = 0; i < dp.length; i++) {
			System.out.println(n - dp[i]);
		}*/

	}

}