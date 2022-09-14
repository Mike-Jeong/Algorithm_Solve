package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 증가하는 부분 수열 4
//13092022

public class b13092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		int[] dp = new int[n];
		int ans = 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {

			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
			}
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			if(ans == dp[i]) {
                stack.push(nums[i]);
                ans--;
            }
		}

		while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

		System.out.println(sb);

	}
}