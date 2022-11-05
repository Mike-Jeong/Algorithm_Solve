package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 증가하는 부분 수열 5
//05112022

public class b05112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		int[] dp = new int[n];

		st = new StringTokenizer(br.readLine());
		nums[0] = Integer.parseInt(st.nextToken());
		dp[0] = 1;

		List<Integer> list = new ArrayList<>();
		list.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());

			if (list.get(list.size() - 1) == nums[i]) {
				dp[i] = list.size();
			} else if (list.get(list.size() - 1) < nums[i]) {
				list.add(nums[i]);
				dp[i] = list.size();
			} else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {

					int mid = (left + right) / 2;

					if (list.get(mid) >= nums[i]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				dp[i] = right + 1;
				list.set(right, nums[i]);
			}
		}

		/*for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.print("\n");*/
		//확인용 코드

		int ans = list.size();
		System.out.println(ans);

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			if (ans == dp[i]) {
				stack.push(nums[i]);
				ans--;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		System.out.println(sb);
	}
}
