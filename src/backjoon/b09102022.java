package backjoon;

import java.io.*;
import java.util.*;

//AC
//09102022

public class b09102022 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			String order = br.readLine();

			LinkedList<Integer> list = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), "[],");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			solve(list, order);
		}

		System.out.println(sb);
	}

	public static void solve(LinkedList<Integer> list, String order) {

		boolean direction = true;

		for (int i = 0; i < order.length(); i++) {
			if (order.charAt(i) == 'R') {
				direction = !direction;
			} else {
				if (direction) {
					if (list.pollFirst() == null) {
						sb.append("error\n");
						return;
					}
				} else {
					if (list.pollLast() == null) {
						sb.append("error\n");
						return;
					}
				}
			}
		}

		sb.append("[");
		while (!list.isEmpty()) {
			if (direction) {
				sb.append(list.pollFirst());
			} else {
				sb.append(list.pollLast());
			}

			if (!list.isEmpty()) {
				sb.append(",");
			}
		}
		sb.append("]");
		sb.append("\n");
	}
}
