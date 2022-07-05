package backjoon;

import java.io.*;
import java.util.*;

//나무 자르기
//05072022

public class b05072022 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int left = 0;
		int right = 0;

		int[] trees = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			right = Math.max(trees[i], right);
		}

		while (left <= right) {

			int mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < trees.length; i++) {
				if (trees[i] > mid) {
					sum += (trees[i] - mid);
				}
			}

			if (sum < target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(right);

	}
}
