package backjoon;

import java.io.*;
import java.util.*;

//LCS 2
//04112022

public class b04112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String s1 = br.readLine();
		String s2 = br.readLine();

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}


		/*for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.print("\n");
		}*/

		System.out.println(dp[s1.length()][s2.length()]);

		Stack<Character> stack = new Stack<>();

		int count = dp[s1.length()][s2.length()];
		int r = s1.length();
		int c = s2.length();
		while (count > 0) {
			if (dp[r][c] == dp[r][c - 1]) {
				c--;
			} else if (dp[r][c] == dp[r - 1][c]) {
				r--;
			} else {
				r--;
				c--;
				count--;
				stack.add(s1.charAt(r));
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}


//테케 1
//ABCDEF
//BEFDEFACDFABZ
// 4, BDEF
