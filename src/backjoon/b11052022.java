package backjoon;

import java.io.*;
import java.util.*;

//파도반 수열
//11052022

public class b11052022 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.valueOf(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.valueOf(st.nextToken());

			long[] nums = new long[num + 1];

			if (num == 1) {
				System.out.println(1);
				continue;
			}

			if (num == 2) {
				System.out.println(1);
				continue;
			}

			nums[0] = 0;
			nums[1] = 1;
			nums[2] = 1;

			for (int j = 3; j < nums.length; j++) {
				nums[j] = nums[j-2] + nums[j-3];
			}

			System.out.println(nums[num]);
		}
	}
}