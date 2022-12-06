package backjoon;

import java.io.*;
import java.util.*;

//최소 스패닝 트리
//05122022

public class b06122022 {

	static int[] parents;
	static int[][] edges;
	static int n;
	static int m;
	static int ans = 0;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

	    st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];
		edges = new int[m][3];

		for (int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());

			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		solve();
		System.out.println(ans);

	}

	//크루스칼 알고리즘
	static void solve() {
		for (int i = 0; i < m; i++) {

			int[] current = edges[i];

			if (find(current[0]) != find(current[1])) {
				//System.out.println(current[0] + " " + current[1] + " " + current[2]);
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