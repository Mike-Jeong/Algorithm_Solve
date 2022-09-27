package backjoon;

import java.io.*;
import java.util.*;

//수 묶기
//27092022

public class b27092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];

		for (int i = 0; i < nums.length; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int left = 0;
		int right = n - 1;
		int ans = 0;

		for (; left < right; left += 2) {
			if (nums[left] < 1 && nums[left + 1] < 1) {
				ans += nums[left] * nums[left + 1];
			} else {
				break;
			}
		}

		for (; right > 0; right -= 2) {
			if (nums[right] > 1 && nums[right - 1] > 1) {
				ans += nums[right] * nums[right - 1];
			} else {
				break;
			}
		}
		for (; right >= left; right--) {
			ans += nums[right];
		}

		System.out.println(ans);
	}
}