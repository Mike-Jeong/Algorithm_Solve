package backjoon;

import java.io.*;
import java.util.*;

//두 수의 합
//07112022

public class b07112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tc = Integer.parseInt(st.nextToken());

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] nums = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(nums);

			int left = 0;
			int right = n - 1;
			int diff = Integer.MAX_VALUE;
			int count = 1;

			while (left < right) {

				int sum = nums[left] + nums[right];

				if (Math.abs(sum - k) == diff) {
					count++;
				} else if (Math.abs(sum - k) < diff) {
					count = 1;
					diff = Math.abs(sum - k);
				}

				if (sum == k) {
					left++;
					right--;
				} else if (sum < k) {
					left++;
				} else {
					right--;
				}
			}

			System.out.println(count);
		}

	}
}
