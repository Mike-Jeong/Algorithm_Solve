package backjoon;

import java.io.*;
import java.util.*;

//전화번호 목록
//28092022

public class b28092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			String[] nums = new String[n];

			for (int j = 0; j < n; j++) {
				nums[j] = br.readLine();
			}

			Arrays.sort(nums);

			boolean isUnique = true;

			for (int j = 0; j < n - 1; j++) {
				if (nums[j + 1].startsWith(nums[j])) {
					isUnique = false;
					break;
				}
			}

			if (isUnique) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
}