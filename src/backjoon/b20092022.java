package backjoon;

import java.io.*;
import java.util.*;

//가장 긴 증가하는 부분 수열 3
//20092022

public class b20092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>();
		int[] ans = new int[n];

		ans[n - 1] = 0;
		list.add(nums[n - 1]);

		for (int i = n - 2; i >= 0; i--) {
			if (list.get(list.size() - 1) >= nums[i]) {
				list.add(nums[i]);
				ans[i] = list.size() - 1;
			} else {
				int left = 1;
				int right = list.size() - 1;

				while (left <= right) {

					int mid = (left + right) / 2;

					if (list.get(mid) > nums[i]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				ans[i] = left;
				list.add(left, nums[i]);

			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("-----------------");

		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}

// *변형 코드
// 입력값
// n = 6, [3, 2, 5, 2, 9, 6];
// 리턴값
// [3, 4, 2, 2, 0, 0]

/*
 public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		list.add(-1000000001);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {

			int num = Integer.parseInt(st.nextToken());

			if (num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
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
			}
		}

		System.out.println(list.size() - 1);

	}
 */

 // 정답 코드