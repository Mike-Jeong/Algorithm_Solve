package backjoon;

import java.io.*;
import java.util.*;

//좋다
//22092022

public class b22092022 {

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

		int count = 0;

		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = n - 1;

			while (left < right) {

				if (left == i) {
					left++;
					continue;
				} else if (right == i) {
					right--;
					continue;
				}

				if (nums[left] + nums[right] == nums[i]) {
					count++;
					break;
				} else if (nums[left] + nums[right] > nums[i]) {
					right--;
				} else {
					left++;
				}
			}
		}

		System.out.println(count);
	}
}