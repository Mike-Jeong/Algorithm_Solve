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
			long left = 1;
			long right = k;

			while (left < right) {

				long mid = (left + right) / 2;
				long count = 0;

				for (int i = 1; i <= n; i++) {
					count += Math.min(mid / i, n);
				}

				if (k <= count) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			System.out.println(left);
		}
	}
}