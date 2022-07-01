package backjoon;

import java.io.*;
import java.util.*;

//연결 요소의 개수
//01072022

public class b01072022 {

	static int count = 0;
	static boolean[] visited;
	static boolean[][] conn;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int n_con = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];

		conn = new boolean[n + 1][n + 1];

		for (int i = 0; i < n_con; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			conn[r][c] = true;
			conn[c][r] = true;
		}

		for (int i = 1; i <= n; i++) {

			if (!visited[i]) {
				count++;
				dfs(i);
			}

		}

		System.out.println(count);

	}

	static void dfs(int node) {

		visited[node] = true;

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i] && conn[node][i]) {
				dfs(i);
			}
		}
	}
}