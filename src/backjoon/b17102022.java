package backjoon;

import java.io.*;
import java.util.*;

//수 고르기
//17102022

public class b17102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		for (int i = 0; i < nums.length; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int left = 0;
		int right = 0;
		int ans = Integer.MAX_VALUE;

		while (left < n) {
			if (nums[left] - nums[right] < m) {
				left++;
				continue;
			}

			if (nums[left] - nums[right] == m) {
				ans = m;
				break;
			}

			ans = Math.min(ans, nums[left] - nums[right]);
			right++;
		}

		System.out.println(ans);

	}
}