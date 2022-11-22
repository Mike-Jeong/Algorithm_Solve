package backjoon;

import java.io.*;
import java.util.*;

//농장 관리
//22112022

public class b22112022 {

	static int[][] map;
	static boolean[][] visited;
	static int ans = 0;

	static int[] rowOrder = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] colOrder = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

	static Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {

			return o2[2] - o1[2];
		}
	});

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				queue.add(new int[] { i, j, map[i][j] });
			}
		}

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			if (!visited[current[0]][current[1]]) {
				// System.out.println(current[0] + " " + current[1]);
				recursion(current[0], current[1]);
				ans++;
			}
		}

		System.out.println(ans);

	}

	static void recursion(int row, int col) {

		visited[row][col] = true;

		for (int i = 0; i < 8; i++) {
			try {
				if (!visited[row + rowOrder[i]][col + colOrder[i]]
						&& map[row][col] >= map[row + rowOrder[i]][col + colOrder[i]]) {
					recursion(row + rowOrder[i], col + colOrder[i]);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
}