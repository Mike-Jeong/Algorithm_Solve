package backjoon;

import java.io.*;
import java.util.*;

//사이클 게임
//15122022

public class b15122022 {

	static int count = 0;
	static int[] parents;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n];
		int[][] edges = new int[n][2];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());

			if (find(edges[i][0]) == find(edges[i][1])) {
				break;
			}

			count++;
			union(edges[i][0], edges[i][1]);
		}

		System.out.println(count == m ? 0 : (count + 1));

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