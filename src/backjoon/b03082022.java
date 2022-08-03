package backjoon;

import java.io.*;
import java.util.*;

//최소비용 구하기 2
//03082022

public class b03082022 {

	static int n;
	static int m;
	static int[] dp;
	static int[] before;
	static Map<Integer, ArrayList<No>> map = new HashMap<>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		dp = new int[n + 1];
		before = new int[n + 1];
		Arrays.fill(dp, 987654321);

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (!map.containsKey(s)) {
				map.put(s, new ArrayList<No>());
			}

			map.get(s).add(new No(e, w));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(dp[end]);

		Stack<Integer> stack = new Stack<>();

		stack.push(end);

		int count = 0;
		while (before[end] != 0) {
			count += 1;
			stack.push(before[end]);
			end = before[end];
		}

		System.out.println(count + 1);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void dijkstra(int start) {

		Queue<No> queue = new PriorityQueue<>();

		No s = new No(start, 0);
		queue.add(s);

		dp[start] = 0;

		while (!queue.isEmpty()) {

			No current = queue.poll();

			ArrayList<No> ends = map.get(current.end);

				if (ends != null) {
					for (int i = 0; i < ends.size(); i++) {
						No next = ends.get(i);
						if (dp[next.end] > dp[current.end] + next.weight) {
							dp[next.end] = dp[current.end] + next.weight;
							before[next.end] = current.end;
							queue.add(new No(next.end, dp[next.end]));
						}
					}
				}

		}
	}
}

class No implements Comparable<No> {
	int end;
	int weight;

	public No(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(No o) {
		return this.weight - o.weight;
	}

}