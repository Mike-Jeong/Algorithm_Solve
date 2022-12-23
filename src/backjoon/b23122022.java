package backjoon;

import java.io.*;
import java.util.*;

//우주신과의 교감
//23122022

public class b23122022 {

	static int[] parents;
	static List<double[]> edges;
	static double ans = 0;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] points = new int[n + 1][2];
		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());

			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			union(start, end);
		}

		edges = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {

				edges.add(new double[] { i, j, Math
						.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2)) });
			}
		}

		Collections.sort(edges, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {

				if (o1[2] < o2[2]) {
					return -1;
				}
				return 1;
			}

		});

		solve();

		System.out.printf("%.2f", ans);
	}

	// 크루스칼 알고리즘
	static void solve() {
		for (int i = 0; i < edges.size(); i++) {

			double[] current = edges.get(i);

			if (find((int) current[0]) != find((int) current[1])) {
				// System.out.println(current[0] + " " + current[1] + " " + current[2]);
				ans += current[2];
				union((int) current[0], (int) current[1]);
			}
		}
	}

	static void union(int x, int y) {

		x = find(x);
		y = find(y);

		if (x < y) {
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