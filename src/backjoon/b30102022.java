package backjoon;

import java.io.*;
import java.util.*;

//최대 힙
//30102022

public class b30102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());

			if (num == 0) {
				System.out.println(queue.isEmpty()? "0" : queue.poll());
			} else {
				queue.add(num);
			}

		}
	}
}