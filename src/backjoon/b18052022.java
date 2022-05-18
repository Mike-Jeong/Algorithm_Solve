package backjoon;

import java.io.*;
import java.util.*;

//N과 M(3)
//18052022

public class b18052022 {

	static int N;
	static int target;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		nums = new int[target];

		recursion(0);

		System.out.println(sb);

	}

	public static void recursion(int index) {

		if (index == target) {

			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]).append(" ");
			}

			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			nums[index] = i;
			recursion(index + 1);
		}
	}
}