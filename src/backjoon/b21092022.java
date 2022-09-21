package backjoon;

import java.io.*;
import java.util.*;

//K번째 수
//21092022

public class b21092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());

		if (k == (n * n)) {
			System.out.println(n * n);
		} else {
			int left = 1;
			int right = k;

			while (left < right) {

				int mid = (left + right) / 2;
				int count = 0;

				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (i * j <= mid) {
							count++;
						} else {
							break;
						}
					}
				}

				System.out.println(count);

				if (count < k) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			System.out.println(left);
		}
	}
}