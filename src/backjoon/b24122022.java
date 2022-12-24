package backjoon;

import java.io.*;
import java.util.*;

//친구비
//24122022

public class b24122022 {

	static int[] parents;
	static int[] prices;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		prices = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			union(start, end);
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(find(parents[i]));
		}

		long sum = set.stream().mapToLong(i -> prices[i]).sum();

		System.out.println(sum > k ? "Oh no" : sum);
	}

	static void union(int x, int y) {

		x = find(x);
		y = find(y);

		if (prices[x] < prices[y]) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

	static int find(int x) {

		if (x == parents[x]) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

}