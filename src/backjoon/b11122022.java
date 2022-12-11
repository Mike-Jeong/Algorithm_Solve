package backjoon;

import java.io.*;
import java.util.*;

//행성 터널
//11122022

public class b11122022 {

	static int[] parents;
	static int[][] points;
	static List<int[]> edges = new ArrayList<>();
	static int n;
	static int ans = 0;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		parents = new int[n];
		points = new int[n][3];

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			parents[i] = i;

			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
			points[i][2] = Integer.parseInt(st.nextToken());

		}

		int[][] position = new int[n][2];

		for (int p = 0; p < 3; p++) {

			for (int i = 0; i < n; i++) {
				position[i][0] = i;
				position[i][1] = points[i][p];
			}

			Arrays.sort(position, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}

			});

			for (int i = 0; i < n - 1; i++) {
				edges.add(new int[] { position[i][0], position[i + 1][0],
						Math.abs(position[i][1] - position[i + 1][1]) });
			}
		}

		Collections.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});

		solve();
		System.out.println(ans);
	}

	static void solve() {
		for (int i = 0; i < edges.size(); i++) {

			int[] current = edges.get(i);

			if (find(current[0]) != find(current[1])) {
				// System.out.println(current[0] + " " + current[1] + " " + current[2]);
				ans += current[2];
				union(current[0], current[1]);
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
		if (parents[x] == x) {
			return x;
		} else {
			return find(parents[x]);
		}
	}

}