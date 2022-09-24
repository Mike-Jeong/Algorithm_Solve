package backjoon;

import java.io.*;
import java.util.*;

//로봇 청소기
//24092022

public class b24092022 {
	public static int n;
	public static int m;
	public static int[][] map;
	public static int ans = 0;
	public static int[] rowOrder = { -1, 0, 1, 0 };
	public static int[] colOrder = { 0, 1, 0, -1 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursion(r, c, d);

		System.out.println(ans);

	}

	public static void recursion(int r, int c, int d) {

		if (map[r][c] == 0) {
			map[r][c] = 2;
			ans++;
		}

		boolean flag = false;
		int origin = d;
		for (int i = 0; i < 4; i++) {
			int next_d = (d + 3) % 4;
			int next_r = r + rowOrder[next_d];
			int next_c = c + colOrder[next_d];

			try {
				if (map[next_r][next_c] == 0) {
					recursion(next_r, next_c, next_d);
					flag = true;
					break;
				}
			} catch (Exception e) {
				continue;
			}

			d = (d + 3) % 4;
		}

		if (!flag) {

			int nextD = (origin + 2) % 4;
			int nextR = r + rowOrder[nextD];
			int nextC = c + colOrder[nextD];

			try {
				if (map[nextR][nextC] != 1) {
					recursion(nextR, nextC, origin);
				}
			} catch (Exception e) {

			}
		}
	}

}