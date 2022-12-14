package backjoon;

import java.io.*;
import java.util.*;

//LCS 4
//14122022

public class b14122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> nums1 = new HashMap<>();
		int[] nums2 = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums1.put(Integer.parseInt(st.nextToken()), i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums2[i] = nums1.get(Integer.parseInt(st.nextToken()));
		}

		int[] dp = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		list.add(nums2[0]);
		dp[0] = 1;

		int max = 1;
		for (int i = 1; i < n; i++) {

			if (list.get(list.size() - 1) < nums2[i]) {
				list.add(nums2[i]);
				dp[i] = list.size();
			} else {
				int left = 0;
				int right = list.size() - 1;

				while (left < right) {

					int mid = (left + right) / 2;

					if (list.get(mid) >= nums2[i]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}
				dp[i] = right + 1;
				list.set(right, nums2[i]);
			}

			max = Math.max(max, dp[i]);
		}

		System.out.println(max);

	}

}