package backjoon;

import java.io.*;
import java.util.*;

//백도어
//29092022

public class b29092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] visible = new boolean[n];
		long[][] route = new long[n][n];
		long[] dp = new long[n];
		Arrays.fill(dp, Long.MAX_VALUE);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < visible.length; i++) {
			visible[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
		}

		visible[n - 1] = false;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());

			route[start][end] = weight;
			route[end][start] = weight;
		}

		Queue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {

				if (o1[1] - o2[1] > 0) {
					return 1;
				} else {
					return -1;
				}
			}

		});

		queue.add(new long[] { 0, 0 });

		while (!queue.isEmpty()) {

			long[] current = queue.poll();

			if (dp[(int) current[0]] > current[1]) {

				dp[(int) current[0]] = current[1];

				for (int i = 0; i < n; i++) {
					if (route[(int) current[0]][i] != 0 && !visible[i]) {
						if (dp[(int) current[0]] + route[(int) current[0]][i] < dp[i]) {
							queue.add(new long[] { i, dp[(int) current[0]] + route[(int) current[0]][i] });
						}
					}
				}
			}
		}

		long ans = dp[n - 1] == Long.MAX_VALUE ? -1 : dp[n - 1];

		System.out.println(ans);

	}
}