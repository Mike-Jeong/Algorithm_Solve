package backjoon;

import java.io.*;
import java.util.*;

//합이 0
//20102022

public class b20102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int index = 0;
		long ans = 0L;

		while (nums[index] <= 0 && index < n) {

			int left = index + 1;
			int right = n - 1;

			while (left < right) {

				int sum = nums[index] + nums[left] + nums[right];

				if (sum == 0) {

					int s = 1;
					int e = 1;

					if (nums[left] == nums[right]) {
						ans += combine(right - left + 1);
						break;
					}

					while (left + 1 < right && nums[left] == nums[left + 1]) {
						s++;
						left++;
					}

					while (left < right - 1 && nums[right] == nums[right - 1]) {
						e++;
						right--;
					}

					ans += s * e;
				}

				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}

			index++;
		}

		System.out.println(ans);

	}

	static int combine(int n) {
		return n * (n - 1) / 2;
	}

}