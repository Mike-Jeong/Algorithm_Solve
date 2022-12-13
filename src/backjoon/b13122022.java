package backjoon;

import java.io.*;
import java.util.*;

//전깃줄 - 2
//13122022

public class b13122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] cable = new int[n + 1][2];
		int[] dp = new int[n + 1];
		boolean[] check = new boolean[n + 1];

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

		int max = 1;
		List<Integer> list = new ArrayList<>();
		list.add(cable[1][1]);
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			
			if (cable[i][1] == cable[i - 1][1]) {
				dp[i] = dp[i - 1];
				continue;
			} else if (cable[i][1] > cable[i - 1][1]) {
				dp[i] = dp[i - 1] + 1;
				list.add(cable[i][1]);
			} else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {

					int mid = (left + right) / 2;

					if (list.get(mid) >= cable[i][1]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				dp[i] = right + 1;
				list.set(right, cable[i][1]);
			}

			max = Math.max(max, dp[i]);
		}

		StringBuilder sb = new StringBuilder();

		sb.append(n - max).append("\n");

		int ck = max;
		while (ck > 0) {
			for (int i = dp.length - 1; i > 0; i--) {
				if (dp[i] == ck) {
					check[i] = true;
					ck--;
					break;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				sb.append(i).append("\n");
			}

			if (max == 0) {
				break;
			}
		}

		System.out.println(sb);

	}

}