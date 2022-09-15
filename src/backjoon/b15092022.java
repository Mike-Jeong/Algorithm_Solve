package backjoon;

import java.io.*;
import java.util.*;

//숨바꼭질
//15092022

public class b15092022 {

	static int[] place = new int[100001];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
		} else {

			Queue<Integer> queue = new LinkedList<>();
			queue.add(n);

			place[n] = 1;

			while (!queue.isEmpty()) {

				int temp = queue.poll();

				for (int i = 0; i < 3; i++) {
					int next;

					if (i == 0) {
						next = temp + 1;
					} else if (i == 1) {
						next = temp - 1;
					} else {
						next = temp * 2;
					}

					if (next == k) {
						System.out.println(place[temp]);
						return;
					}

					if (next >= 0 && next < place.length && place[next] == 0) {
						queue.add(next);
						place[next] = place[temp] + 1;
					}
				}

			}
		}
	}
}