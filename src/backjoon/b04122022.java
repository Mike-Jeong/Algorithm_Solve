package backjoon;

import java.io.*;
import java.util.*;

//키 순서
//04122022

public class b04122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			map[start][end] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int j2 = 1; j2 <= n; j2++) {
					if (map[j][i] && map[i][j2]) {
						map[j][j2] = true;
					}
				}
			}
		}

		int[] counts = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] || map[j][i]) {
					counts[i]++;
				}
			}
		}

		int ans = 0;
		for (int count : counts) {
			//System.out.println(count);
			if (count == n - 1) {
				ans++;
			}
		}

		System.out.println(ans);

	}
}