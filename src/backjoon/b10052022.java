package backjoon;

import java.io.*;
import java.util.*;

//N과 M(1) (15649)
//10052022

public class b10052022 {

	static int target;
	static boolean[] nums;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.valueOf(st.nextToken());

		nums = new boolean[N+1];

		target = Integer.valueOf(st.nextToken());

		recursion(0, "");

	}

	public static void recursion(int count, String ans) {
		if (count == target) {
			System.out.println(ans.trim());
			return;
		}

		for (int i = 1; i < nums.length; i++) {
			if (!nums[i]) {

				nums[i] = true;

				String current = ans + i + " ";
				
				recursion(count + 1, current);

				nums[i] = false;
			}
		}
	}
}