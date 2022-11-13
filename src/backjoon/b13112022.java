package backjoon;

import java.io.*;
import java.util.*;

//카드2
//13112022

public class b13112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		boolean addAgain = false;

		while (queue.size() > 1) {
			int cur = queue.poll();

			if (addAgain) {
				queue.add(cur);
			}

			addAgain = !addAgain;
		}

		System.out.println(queue.poll());

	}
}
