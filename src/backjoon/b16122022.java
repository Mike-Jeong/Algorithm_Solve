package backjoon;

import java.io.*;
import java.util.*;

//줄 세우기
//16122022

public class b16122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[] count = new int[n + 1];

		list.add(null);

		for (int i = 1; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.get(start).add(end);
			count[end]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < count.length; i++) {
			if (count[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			
			int current = queue.poll();
			
			System.out.print(current + " ");

			List<Integer> neighbor = list.get(current);

			for (int i = 0; i < neighbor.size(); i++) {

				count[neighbor.get(i)]--;

				if (count[neighbor.get(i)] == 0) {
					queue.add(neighbor.get(i));
				}
			}
		}

	}
}