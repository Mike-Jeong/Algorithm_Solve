package backjoon;

import java.io.*;
import java.util.*;

//큐
//27102022

public class b27102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Deque<String> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {

			String order = br.readLine();

			String[] orders = order.split(" ");

			switch (orders[0]) {
				case "push":
					queue.add(orders[1]);
					break;

				case "pop":
					System.out.println(queue.isEmpty() ? "-1" : queue.poll());
					break;

				case "size":
					System.out.println(queue.size());
					break;

				case "empty":
					System.out.println(queue.isEmpty() ? "1" : "0");
					break;

				case "front":
					System.out.println(queue.isEmpty() ? "-1" : queue.peek());
					break;

				case "back":
					System.out.println(queue.isEmpty() ? "-1" : queue.peekLast());
					break;

				default:
					break;
			}
		}
	}
}