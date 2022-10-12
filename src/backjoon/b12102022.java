package backjoon;

import java.io.*;
//import java.util.*;

//문자열 폭발
//12102022

public class b12102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String input = br.readLine();
		char[] bomb = br.readLine().toCharArray();

		char[] ans = new char[input.length()];

		int length = bomb.length;

		StringBuilder sb = new StringBuilder();

		int index = 0;
		for (int i = 0; i < input.length(); i++) {
			ans[index] = input.charAt(i);
			// System.out.println(ans[index] + " " + index);
			index++;
			if (ans[index - 1] == bomb[length - 1]) {

				if (index - length < 0) {

					continue;
				}

				boolean flag = false;
				for (int j = 0; j < length; j++) {
					if (ans[index - 1 - j] != bomb[length - 1 - j]) {
						flag = true;
						break;
					}
				}

				if (!flag) {
					index -= length;
				}
			}
		}

		if (index == 0) {
			System.out.println("FRULA");
		} else {
			for (int i = 0; i < index; i++) {
				sb.append(ans[i]);
			}
			System.out.println(sb);
		}

	}
}