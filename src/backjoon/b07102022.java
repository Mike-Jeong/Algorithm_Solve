package backjoon;

import java.io.*;
import java.util.*;

//부분합
//07102022

public class b07102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int[] sums = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sums[i + 1] = sums[i] + nums[i];
		}

		if (sums[n] < s) {
			System.out.println(0);
		} else {
			int left = 0;
			int right = 0;
			int ans = n;

			while (left <= right && right <= n) {
				int sum = sums[right] - sums[left];
				if (sum < s) {
					right++;
				} else {
					ans = Math.min(ans, right - left);
					left++;
				}
			}

			System.out.println(ans);
		}
	}
}
