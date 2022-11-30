package backjoon;

import java.io.*;
import java.util.*;

//IOIOI
//30112022

public class b30112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		int answer = 0;
		int[] dp = new int[m];

		Arrays.fill(dp, 0);

		for (int i = 2; i < m; i++) {
			String temp = str.substring(i - 2, i + 1);
			if (temp.equals("IOI")) {
				dp[i] = dp[i - 2] + 1;
			}
			if (dp[i] >= n) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}