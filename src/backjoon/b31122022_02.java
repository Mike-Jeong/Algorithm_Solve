package backjoon;

import java.io.*;
import java.util.*;

//Square Coins
//31122022

public class b31122022_02 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine());

		int[] dp = new int[301];
		dp[0] = 1;

		for (int i = 1; i <= 17; i++) {
			int n = i * i;

			for (int j = n; j <= 300; j++) {

				dp[j] += dp[j - n];
			}

		}

		while (true) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			}

			System.out.println(dp[n]);

		}
	}
}


// 1 4 9 10
//      1 2 3 4 5 6 7 8 9 10
//    0 0 0 0 0 0 0 0 0 0 0
//  1 0 1 1 1 1 1 1 1 1 1 1
//  4 0 1 1 1 2 2 2 2 3 3 3 
//  9 0 1 1 1 2 2 2 2 3 4 4