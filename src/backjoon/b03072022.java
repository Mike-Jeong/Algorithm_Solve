package backjoon;

import java.io.*;
import java.util.*;

//택배 배송
//03072022

public class b03072022 {

	static boolean[] visited;
	static Map<Integer, ArrayList<Node>> map = new HashMap<>();
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		dp = new int[n + 1];

		Arrays.fill(dp, 987654321);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (!map.containsKey(s)) {
				map.put(s, new ArrayList<Node>());
			}

			map.get(s).add(new Node(e, w));

			if (!map.containsKey(e)) {
				map.put(e, new ArrayList<Node>());
			}

			map.get(e).add(new Node(s, w));
		}

		PriorityQueue<Node> queue = new PriorityQueue<>();

		queue.add(new Node(1, 0));
		dp[1] = 0;

		while (!queue.isEmpty()) {

			Node current = queue.poll();

			if (!visited[current.end]) {

				visited[current.end] = true;

				ArrayList<Node> cNodes = map.get(current.end);

				for (int i = 0; i < cNodes.size(); i++) {
					Node next = cNodes.get(i);

					if(dp[next.end] > dp[current.end] + next.weight) {
						dp[next.end] = dp[current.end] + next.weight;
						queue.add(new Node(next.end, dp[next.end]));
					}
				}
			}
		}

		System.out.println(dp[n]);

	}
}

class Node implements Comparable<Node> {
	int end;
	int weight;

	Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}

}
