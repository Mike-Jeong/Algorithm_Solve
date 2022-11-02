package backjoon;

import java.io.*;
import java.util.*;

//용액 합성하기
//02112022

public class b02112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] liqs = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < liqs.length; i++) {
			liqs[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 987654321;

		int left = 0;
		int right = n - 1;

		while (left < right) {
			int sum = liqs[left] + liqs[right];

			if (Math.abs(sum) < Math.abs(ans)) {
				ans = sum;
			}
			if (sum == 0) {
				break;
			}

			if (liqs[left] + liqs[right] > 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(ans);

	}
}
