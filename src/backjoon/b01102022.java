package backjoon;

import java.io.*;
import java.util.*;

//숨바꼭질 4
//01102022

public class b01102022 {

	private static int[] visited = new int[100001];
	private static int[] parent = new int[100001];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		bfs(n, k);
		System.out.println(visited[k] - 1);

		Stack<Integer> s = new Stack<>();
		int idx = k;
		while (idx != n) {
			s.push(idx);
			idx = parent[idx];
		}
		s.push(idx);

		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}

	static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now + 1 <= 100000 && visited[now + 1] == 0) {
				visited[now + 1] = visited[now] + 1;
				parent[now + 1] = now;
				q.add(now + 1);
			}
			if (now - 1 >= 0 && visited[now - 1] == 0) {
				visited[now - 1] = visited[now] + 1;
				parent[now - 1] = now;
				q.add(now - 1);
			}
			if (now * 2 <= 100000 && visited[now * 2] == 0) {
				visited[now * 2] = visited[now] + 1;
				parent[now * 2] = now;
				q.add(now * 2);
			}

			if (visited[end] != 0) {
				return;
			}
		}
	}
}