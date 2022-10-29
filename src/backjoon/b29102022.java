package backjoon;

import java.io.*;
import java.util.*;

//최소 힙
//29102022

public class b29102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new PriorityQueue<>();

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