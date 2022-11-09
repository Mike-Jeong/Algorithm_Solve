package backjoon;

import java.io.*;
import java.util.*;

//도서관
//09112022

public class b09112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<Integer> posQueue = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> negQueue = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int current = Integer.parseInt(st.nextToken());

			if (current < 0) {
				negQueue.add(current);
			} else {
				posQueue.add(current);
			}
		}

		if (posQueue.isEmpty()) {

			System.out.println(calculate(true, negQueue, m));

		} else if (negQueue.isEmpty()) {

			System.out.println(calculate(true, posQueue, m));

		} else if (Math.abs(negQueue.peek()) > posQueue.peek()) {

			System.out.println(calculate(true, negQueue, m) + calculate(false, posQueue, m));

		} else {
			System.out.println(calculate(true, posQueue, m) + calculate(false, negQueue, m));
		}
	}

	private static int calculate(boolean isFar, Queue<Integer> queue, int carry) {

		int cal = 0;

		while (!queue.isEmpty()) {
			int cur = isFar ? queue.poll() : queue.poll() * 2;
			isFar = false;
			cal += cur;

			for (int i = 1; i < carry; i++) {

				if (queue.isEmpty()) {
					return Math.abs(cal);
				}

				queue.poll();
			}
		}

		return Math.abs(cal);
	}
}
