package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 증가하는 부분 수열 2
//19092022

public class b19092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		list.add(0);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {

			int num = Integer.parseInt(st.nextToken());

			if (num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {
					int mid = (left + right) / 2;
					if (list.get(mid) >= num) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				list.set(right, num);
			}
		}

		System.out.println(list.size() - 1);

	}
}