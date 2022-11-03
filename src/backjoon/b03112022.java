package backjoon;

import java.io.*;
import java.util.*;

//휴게소 세우기
//03112022

public class b03112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] points = new int[n + 2];
		points[0] = 0;
		points[n + 1] = l;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			points[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(points);

		int left = 0;
		int right = l;

		while (left < right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < points.length; i++) {
				sum += (points[i] - points[i - 1] - 1) / mid;
			}

			if (sum > m) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		System.out.println(left);

	}
}
