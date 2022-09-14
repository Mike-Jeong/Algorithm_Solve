package backjoon;

import java.io.*;
import java.util.*;

//미로 탐색
//14092022

public class b14092022 {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] rowOrder = new int[] { -1, 0, 1, 0 };
	static int[] colOrder = new int[] { 0, -1, 0, 1 };
	static int ans = 1;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {

			String line = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {

		queue.add(new int[] { 0, 0, 1});

		int ans = 0;

		while (!queue.isEmpty()) {

			int[] cordi = queue.poll();
			if (cordi[0] == n - 1 && cordi[1] == m - 1) {
				ans = cordi[2];
				break;
			}

			if (!visited[cordi[0]][cordi[1]]) {
				visited[cordi[0]][cordi[1]] = true;

				for (int i = 0; i < 4; i++) {
					try {
						if (map[cordi[0] + rowOrder[i]][cordi[1] + colOrder[i]] == 1
								&& !visited[cordi[0] + rowOrder[i]][cordi[1] + colOrder[i]]) {
							queue.add(new int[]{cordi[0] + rowOrder[i], cordi[1] + colOrder[i], cordi[2] + 1});
						}
					} catch (Exception e) {
						continue;
					}
				}

			}
		}

		return ans;
	}
}