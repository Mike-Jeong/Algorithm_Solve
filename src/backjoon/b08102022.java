package backjoon;

import java.io.*;
//import java.util.*;

//A와 B
//08102022

public class b08102022 {

	static String s;
	static String t;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		s = br.readLine();
		t = br.readLine();

		StringBuilder sb = new StringBuilder(t);

		while (true) {

			if (sb.length() == s.length()) {
				if (s.equals(sb.toString())) {
					System.out.println(1);
					break;
				}
				System.out.println(0);
				break;
			}

			if (sb.charAt(sb.length() - 1) == 'B') {
				sb = sb.deleteCharAt(sb.length() - 1).reverse();
			} else {
				sb = sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
