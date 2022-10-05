package backjoon;

import java.io.*;
import java.util.*;

//단어 수학
//05102022

public class b05102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		String[] nums = new String[n];
		int[] check = new int[26];

		for (int i = 0; i < n; i++) {
			nums[i] = br.readLine();

			int num = (int) Math.pow(10, nums[i].length() - 1);

			for (int j = 0; j < nums[i].length(); j++) {
				check[(int) nums[i].charAt(j) - 65] += num;
				num /= 10;
			}
		}

		Arrays.sort(check);

		int index = 9;
		int sum = 0;
		for (int i = check.length - 1; i >= 0; i--) {
			if (check[i] == 0) {
				break;
			}
			sum += check[i] * index;
			index--;
		}

		System.out.println(sum);

	}
}
