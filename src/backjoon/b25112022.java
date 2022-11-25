package backjoon;

import java.io.*;
import java.util.*;

//트럭
//25112022

public class b25112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Queue<Integer> truckQueue = new LinkedList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truckQueue.offer(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < w; i++) {
			queue.add(0);
		}

		int time = 0;
		int busWeight = 0;

		while (!queue.isEmpty()) {

			time++;

			busWeight -= queue.poll();

			if (!truckQueue.isEmpty()) {
				if (truckQueue.peek() + busWeight <= l) {

					busWeight += truckQueue.peek();
					queue.offer(truckQueue.poll());
					
				} else {
					queue.offer(0);
				}
			}
		}

		System.out.println(time);
	}
}
