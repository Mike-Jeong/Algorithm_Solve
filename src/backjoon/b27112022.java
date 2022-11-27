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

		PriorityQueue<Integer> powerSocket = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			if (m > powerSocket.size()) {
				powerSocket.add(devices[i]);
			} else {
				powerSocket.add(devices[i] + powerSocket.poll());
			}
		}

		System.out.println(powerSocket.toArray()[powerSocket.size() - 1]);

	}
}
