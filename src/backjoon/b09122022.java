package backjoon;

import java.io.*;
import java.util.*;

//팰린드롬?
//09122022

public class b09122022 {

	static int[] nums;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		nums = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(solution(start, end)).append("\n");
		}

		System.out.println(sb);

	}

	static int solution(int start, int end) {

		while (start < end) {

			if (nums[start] != nums[end]) {
				return 0;
			}

			start++;
			end--;
		}

		return 1;
	}
}