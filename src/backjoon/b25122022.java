package backjoon;

import java.io.*;
import java.util.*;

//트리
//25122022

public class b25122022 {

	static int[] parents;
	static int count = 1;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine());

		while (true) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0) {
				break;
			}

			parents = new int[n + 1];
			boolean[] check = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				int startParent = find(start);
				int endParent = find(end);

				if (startParent != endParent) {
					union(start, end);

					if (check[startParent] || check[endParent]) {
						check[startParent] = true;
						check[endParent] = true;
					}

				} else {
					check[startParent] = true;
				}

			}

			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {

				int ck = find(parents[i]);

				if (!check[ck]) {
					set.add(ck);
				}
			}

			if (set.size() > 1) {
				System.out.println(String.format("Case %d: A forest of %d trees.", count, set.size()));
			} else {
				System.out.println(
						String.format("Case %d: ", count) + (set.size() == 0 ? "No trees." : "There is one tree."));
			}

			count++;

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