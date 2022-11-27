package backjoon;

import java.io.*;
import java.util.*;

//콘센트
//27112022

public class b27112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Integer[] devices = new Integer[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			devices[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(devices, Collections.reverseOrder());

		if (n > m) {
			PriorityQueue<Integer> powerSocket = new PriorityQueue<>();

			for (int i = 0; i < m; i++) {
				powerSocket.add(devices[i]);
			}

			for (int i = m; i < n; i++) {

				int finished = powerSocket.poll();
				powerSocket.add(devices[i] + finished);
			}

			int ans = powerSocket.stream()
			.mapToInt(x -> x)
			.max()
			.getAsInt();
			System.out.println(ans);

		} else {
			System.out.println(devices[0]);
		}

	}
}

// 수정본