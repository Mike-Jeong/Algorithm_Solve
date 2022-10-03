package backjoon;

import java.io.*;
import java.util.*;

//카드 정렬하기
//03102022

public class b03102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			queue.add(num);
		}

		int ans = 0;
		while (queue.size() > 1) {
			int a = queue.poll();
			int b = queue.poll();

			ans += a + b;
			queue.add(a + b);
		}

		System.out.println(ans);

	}
}