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

		char[] s = br.readLine().toCharArray();

		int[] dp = new int[m];

		int ans = 0;
		for (int i = 1; i < m - 1; i++) {

			if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {

				if (i == 1) {
					dp[1] = 1;
				} else {
					dp[i] = dp[i - 2] + 1;
				}
			}

			if (dp[i] >= n) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}