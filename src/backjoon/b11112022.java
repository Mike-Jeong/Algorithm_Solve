package backjoon;

import java.io.*;
import java.util.*;

//최소 회의실 개수
//11112022

public class b11112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] meeting = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meeting, new Comparator<int[]>() {

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

		queue.add(meeting[0]);

		for (int i = 1; i < n; i++) {
			if (queue.peek()[1] <=meeting[i][0]) {
				queue.poll();
			}
			queue.add(meeting[i]);
		}

		System.out.println(queue.size());

	}
}
