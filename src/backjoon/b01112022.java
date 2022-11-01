package backjoon;

import java.io.*;
import java.util.*;

//절댓값 힙
//01112022

public class b01112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}

				return Math.abs(o1) - Math.abs(o2);
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());

			if (num == 0) {
				sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
				continue;
			}

			queue.add(num);
		}

		System.out.println(sb.toString());

	}
}