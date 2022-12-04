package backjoon;

import java.io.*;
import java.util.*;

//별 찍기 - 10
//03122022

public class b03122022 {

	static char[][] map;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = '*';
			}
		}

		recursion(0, 0, n);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void recursion(int row, int col, int range) {

		if (range == 1) {
			return;
		}

		int count = 0;
		for (int i = 0; i < range; i += (range / 3)) {
			for (int j = 0; j < range; j += (range / 3)) {

				if (count == 4) {

					for (int j2 = 0; j2 < range / 3; j2++) {
						for (int k = 0; k < range / 3; k++) {
							map[j2 + i + row][k + j + col] = ' ';
						}
					}

				} else {
					recursion(i + row, j + col, range / 3);
				}

				count++;
			}
		}
	}
}