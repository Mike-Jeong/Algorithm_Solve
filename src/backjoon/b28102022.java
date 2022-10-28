package backjoon;

import java.io.*;
import java.util.*;

//덱
//28102022

public class b28102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Deque<String> deque = new LinkedList<>();

		for (int i = 0; i < n; i++) {

			String order = br.readLine();

			String[] orders = order.split(" ");

			switch (orders[0]) {
				case "push_front":
					deque.addFirst(orders[1]);
					break;
				case "push_back":
					deque.addLast(orders[1]);
					break;
				case "pop_front":
					System.out.println(deque.isEmpty() ? "-1" : deque.pollFirst());
					break;
				case "pop_back":
					System.out.println(deque.isEmpty() ? "-1" : deque.pollLast());
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					System.out.println(deque.isEmpty() ? "1" : "0");
					break;
				case "front":
					System.out.println(deque.isEmpty() ? "-1" : deque.peekFirst());
					break;
				case "back":
					System.out.println(deque.isEmpty() ? "-1" : deque.peekLast());
					break;

				default:
					break;
			}
		}
	}
}