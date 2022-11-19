package backjoon;

import java.io.*;
import java.util.*;

//단지번호붙이기
//19112022

public class b19112022 {

	static int[][] map;
	static boolean[][] visited;
	static Queue<Integer> queue = new PriorityQueue<>();

	static int[] rowOrder = new int[] { 0, 1, 0, -1 };
	static int[] colOrder = new int[] { 1, 0, -1, 0 };

	static int count;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String mapString = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = mapString.charAt(j) - 48;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					count = 0;
					recursion(i, j);
					queue.add(count);
				}
			}
		}

		System.out.println(queue.size());
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

	static void recursion(int row, int col) {
		visited[row][col] = true;
		count++;

		for (int i = 0; i < 4; i++) {
			try {
				if (map[row + rowOrder[i]][col + colOrder[i]] == 1 && !visited[row + rowOrder[i]][col + colOrder[i]]) {
					recursion(row + rowOrder[i], col + colOrder[i]);
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
}