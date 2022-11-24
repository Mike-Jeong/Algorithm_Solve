package backjoon;

import java.io.*;
import java.util.*;

//항체 인식
//24112022

public class b24112022 {

	static int[][] mapBefore;
	static int[][] mapAfter;

	static boolean[][] visited;

	static int[] rowOrder = new int[] { -1, 0, 1, 0 };
	static int[] colOrder = new int[] { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		mapBefore = new int[n][m];
		mapAfter = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {

				mapBefore[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {

				mapAfter[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean check = true;
		int count = 0;

		loop: 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (!visited[i][j] && mapBefore[i][j] != mapAfter[i][j]) {

					if (count > 0) {
						check = false;
						break loop;
					}

					recursion(i, j, mapBefore[i][j], mapAfter[i][j]);
					count++;

					for (int j2 = 0; j2 < n; j2++) {
						for (int k = 0; k < m; k++) {
							if (visited[j2][k] && mapBefore[j2][k] != mapAfter[j2][k]) {
								check = false;
								break loop;
							}
						}
					}

				}
			}
		}

		System.out.println(check ? "YES" : "NO");

	}

	static void recursion(int row, int col, int target, int change) {

		visited[row][col] = true;
		mapBefore[row][col] = change;

		for (int i = 0; i < 4; i++) {
			try {
				if (!visited[row + rowOrder[i]][col + colOrder[i]]
						&& mapBefore[row + rowOrder[i]][col + colOrder[i]] == target) {

					recursion(row + rowOrder[i], col + colOrder[i], target, change);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
}
