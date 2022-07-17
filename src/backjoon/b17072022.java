package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 바이토닉 부분 수열
//17072022

public class b17072022 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int[] dp_max = new int[n];
		int[] dp_min = new int[n];
		int[] dp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {

			nums[i] = Integer.parseInt(st.nextToken());

			dp_max[i] = 1;

			for (int j = i - 1; j >= 0; j--) {

                if (nums[i] > nums[j]) {
                    dp_max[i] = Math.max(dp_max[i], dp_max[j] + 1);
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

			dp[i] = dp_max[i] + dp_min[i];
		}

		int max = 0;
		for (int i = 0; i < dp_max.length; i++) {
			max = Math.max(dp[i], max);
		}

		System.out.println(max);

	}
}