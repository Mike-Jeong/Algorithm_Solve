package backjoon;

import java.io.*;
//import java.util.*;

//A와 B 2
//23102022

public class b23102022 {

	static String s;
	static String t;
	static boolean isEqual = false;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		s = br.readLine();
		t = br.readLine();

		recursion(t);

		System.out.println(isEqual ? "1" : "0");

	}

	static void recursion(String string) {

		if (string.length() == s.length()) {
			if (s.equals(string)) {
				isEqual = true;
			}

			return;
		}

		if (string.charAt(0) == 'B') {

			StringBuilder sb = new StringBuilder(string);

			recursion(sb.reverse().deleteCharAt(sb.length() - 1).toString());
		}

		if (string.charAt(string.length() - 1) == 'A') {
			recursion(string.substring(0, string.length() - 1));
		}
	}

}
