package backjoon;

import java.io.*;
import java.util.*;

//집합의 표현
//19122022

public class b19122022 {

	static int[] parents;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		} 

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int command = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (command == 0) {
				
				union(start, end);

			} else if (command == 1) {

				sb.append(find(start) == find(end) ? "YES" : "NO").append("\n");

			}
		}

		System.out.println(sb);
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
		}

		return parents[x] = find(parents[x]);
	}

}