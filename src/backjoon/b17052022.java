package backjoon;

import java.io.*;
import java.util.*;

//프린터 큐
//17052022

public class b17052022 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			int nums = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			Queue<int[]> queue = new LinkedList<>();
			PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
			
			for (int j = 0; j < nums; j++) {
				int p = Integer.parseInt(st.nextToken());
				queue.add(new int[]{j, p});
				q.add(p);
			}

			int index = 1;

			while (!queue.isEmpty()) {

				int[] now = queue.poll();

				if (q.peek() == now[1]) {

					q.poll();
					if (target == now[0]) {
						System.out.println(index);
						break;
					}
					index++;
				
				} else{
					queue.add(now);
				}
			}
		}

	}
}