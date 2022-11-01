package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 바이토닉 부분 수열 (다시 풀기)
//01112022

//풀이과정 2
//시간 복잡도 O(nlogn)

public class b01112022_02 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int[] dp = new int[n];
		int[] dp_min = new int[n];

		List<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {

			nums[i] = Integer.parseInt(st.nextToken());

			if (i == 0) {
				list.add(nums[i]);
				continue;
			}

			if (list.get(list.size() - 1) < nums[i]) {
				list.add(nums[i]);
				dp[i] = list.size() - 1;
			} else {
				dp[i] = binarySearch(list, nums[i]);
			}
		}

		list = new ArrayList<>();

		for (int i = n - 1; i >= 0; i--) {

			if (i == n - 1) {
				list.add(nums[i]);
				dp[i]++;
				continue;
			}

			if (list.get(list.size() - 1) < nums[i]) {
				list.add(nums[i]);
				dp_min[i] = list.size() - 1;
			} else {
				dp_min[i] = binarySearch(list, nums[i]);
			}

			dp[i] = dp[i] + dp_min[i] + 1;
		}

		int ans = 0;

		for (int i = 0; i < dp.length; i++) {
			ans = Math.max(dp[i], ans);
		}

		System.out.println(ans);

	}

	public static int binarySearch(List<Integer> list, int num) {
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

		return right;
	}
}


// 풀이 과정 1
//시간 복잡도 O(n^2)
//공간 복잡도 O(n)
/*
public class b01112022_02 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int[] dp = new int[n];
		int[] dp_min = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());		
			
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {

			dp_min[i] = 0;

			for (int j = i + 1; j < n; j++) {
				if (nums[i] > nums[j]) {
					dp_min[i] = Math.max(dp_min[i], dp_min[j] + 1);
				}
			}

			dp[i] = dp[i] + dp_min[i];
		}

		int ans = 0;

		for (int i = 0; i < dp.length; i++) {
			ans = Math.max(dp[i], ans);
		}

		System.out.println(ans);

	}
}
 */