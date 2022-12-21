package backjoon;

import java.io.*;
import java.util.*;

//여행 가자
//21122022

public class b21122022 {

	static int[] parents;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		parents = new int[n];

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int check = Integer.parseInt(st.nextToken());

				if (check == 1) {
					union(i, j);
				}

			}
		}

		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());

		boolean available = true;
		for (int i = 1; i < m; i++) {
			int city = Integer.parseInt(st.nextToken());

			if (parents[startCity - 1] != parents[city - 1]) {
				available = false;
				break;
			}
		}

		System.out.println(available ? "YES" : "NO");

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