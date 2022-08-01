package backjoon;

import java.io.*;
import java.util.*;

//보물섬
//01082022

public class b01082022 {

	static int n;
	static int m;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> list = new LinkedList<>();
	static int ans = 0;
	static int[] rowOrder = new int[] { -1, 0, 1, 0 };
	static int[] colOrder = new int[] { 0, -1, 0, 1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {

			String line = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);

				if (map[i][j] == 'L') {
					list.add(new int[] { i, j });
				}
			}
		}

		for (int[] loc : list) {
			visited = new boolean[n][m];
			bfs(loc);
		}

		System.out.println(ans);

	}

	public static void bfs(int[] loc) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{loc[0], loc[1], 0});

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			if (!visited[now[0]][now[1]]) {

				visited[now[0]][now[1]] = true;
				ans = Math.max(ans, now[2]);

				for (int i = 0; i < 4; i++) {
					try {
						if (map[now[0] + rowOrder[i]][now[1] + colOrder[i]] == 'L' && !visited[now[0] + rowOrder[i]][now[1] + colOrder[i]]) {
							queue.add(new int[]{now[0] + rowOrder[i], now[1] + colOrder[i], now[2] + 1});
						}
					} catch (Exception e) {
						continue;
					}
				}
			}
		}
	}
}