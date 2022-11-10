package backjoon;

import java.io.*;
import java.util.*;

//강의실
//10112022

public class b10112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] lec = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int index = Integer.parseInt(st.nextToken());

			lec[index - 1][0] = Integer.parseInt(st.nextToken());
			lec[index - 1][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(lec, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}

				return o1[0] - o2[0];
			}

		});

		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}

		});

		queue.add(lec[0]);

		for (int i = 1; i < n; i++) {
			if (queue.peek()[1] <=lec[i][0]) {
				queue.poll();
			}
			queue.add(lec[i]);
		}

		System.out.println(queue.size());
	}
}
