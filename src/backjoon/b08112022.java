package backjoon;

import java.io.*;
import java.util.*;

//좋은 수열
//08112022

public class b08112022 {

	static int n;
	static String ans = "";
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		recursion(0, "");

		System.out.println(ans);
	}

	private static void recursion(int count, String num) {

		if (!ans.equals("")) {
			return;
		}

		if (count == n) {
			ans = num;
			return;
		}

		for (int i = 1; i <= 3; i++) {

			String current = num + i;

			if (check(current)) {
				recursion(count + 1, current);
			}
		}
	}

	private static boolean check(String num) {

		for (int i = 1; i <= num.length() / 2; i++) {
			for (int j = 0; j <= num.length() - (i * 2); j++) {
				if (num.substring(j, i + j).equals(num.substring(i + j, (i * 2) + j))) {
					return false;
				}
			}
		}
		return true;
	}
}
