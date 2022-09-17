package backjoon;

import java.io.*;
import java.util.*;

//순회강연
//17092022

public class b17092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {

				return o2[0] - o1[0];
			}
		});

		int n = Integer.parseInt(st.nextToken());

		int maxDay = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			if (day > maxDay) {
				maxDay = day;
			}

			queue.add(new int[]{price, day});
		}

		int[] maxPrices = new int[maxDay + 1];

		while (!queue.isEmpty()) {

			int[] current = queue.poll();

			for (int i = current[1]; i >= 1; i--) {
				if (maxPrices[i] < current[0]) {
					maxPrices[i] = current[0];
					break;
				}
			}
		}

		int ans = 0;

		for (int i = 1; i < maxPrices.length; i++) {
			ans += maxPrices[i];
		}

		System.out.println(ans);
	}
}