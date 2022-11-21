package backjoon;

import java.io.*;
import java.util.*;

//안전 영역
//20112022

public class b20112022 {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static List<Island> list = new LinkedList<>();

	static int[] rowOrder = new int[] { 0, 1, 0, -1 };
	static int[] colOrder = new int[] { 1, 0, -1, 0 };

	static int ans = -1;
	static int maxLevel = -1;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list.add(new Island(i, j, map[i][j]));
				maxLevel = Math.max(maxLevel, map[i][j]);
			}
		}

		Collections.sort(list, Collections.reverseOrder());

		while (maxLevel >= 0) {

			int count = 0;
			visited = new boolean[n][n];

			for (int i = 0; i < list.size(); i++) {

				Island now = list.get(i);

				if (now.level < maxLevel) {
					break;
				}

				if (!visited[now.row][now.col]) {
					//System.out.println(now.row + " " + now.col + " " + maxLevel);
					recursion(now.row, now.col, maxLevel);
					count++;
				}
			}

			ans = Math.max(ans, count);
			maxLevel--;

		}

		//System.out.println(maxLevel);
		System.out.println(ans);
	}

	static void recursion(int row, int col, int level) {
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			try {
				if (map[row + rowOrder[i]][col + colOrder[i]] >= level
						&& !visited[row + rowOrder[i]][col + colOrder[i]]) {
					recursion(row + rowOrder[i], col + colOrder[i], level);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
}

class Island implements Comparable<Island> {

	int row;
	int col;
	int level;

	public Island(int row, int col, int level) {
		this.row = row;
		this.col = col;
		this.level = level;
	}

	@Override
	public int compareTo(Island o) {
		return level - o.level;
	}
}