package backjoon;

import java.io.*;
import java.util.*;

//가운데를 말해요
//29112022

public class b29112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			if (minQueue.size() == maxQueue.size()) {
				maxQueue.add(num);
			} else {
				minQueue.add(num);
			}

			if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if (minQueue.peek() < maxQueue.peek()) {

					int minValue = minQueue.poll();
					minQueue.add(maxQueue.poll());
					maxQueue.add(minValue);
				}
			}

			sb.append(maxQueue.peek()).append("\n");
		}

		System.out.println(sb);
	}
}

// 다시 풀어볼것!