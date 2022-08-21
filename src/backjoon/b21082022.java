package backjoon;

import java.io.*;
import java.util.*;

//
//21082022

public class b21082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n];
		dp1[0] = nums[0];

		int ans = dp1[0];

		for (int i = 1; i < n; i++) {
			dp1[i] = Math.max(dp1[i - 1] + nums[i], nums[i]);

			ans = Math.max(ans, dp1[i]);
		}

		int[] dp2 = new int[n];
		dp2[n - 1] = nums[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i + 1] + nums[i], nums[i]);
		}

		for (int i = 1; i < n - 1; i++) {
			int temp = dp1[i - 1] + dp2[i + 1];

			ans = Math.max(ans, temp);
		}

		System.out.println(ans);

    }
}