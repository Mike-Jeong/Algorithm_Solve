package backjoon;

import java.io.*;
import java.util.*;

//행복 유치원
//04102022

public class b04102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		int[] diffs = new int[n - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			diffs[i - 1] = nums[i] - nums[i - 1];
		}

		Arrays.sort(diffs);

		int ans = 0;
		for (int i = 0; i <= diffs.length - k; i++) {
			ans += diffs[i];
		}

		System.out.println(ans);

	}
}