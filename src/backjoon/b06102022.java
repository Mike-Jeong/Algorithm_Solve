package backjoon;

import java.io.*;
import java.util.*;

//회문
//06102022

public class b06102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			System.out.println(checkPalindrome(string, 0, 0, string.length() - 1));
		}

	}

	public static int checkPalindrome(String string, int count, int left, int right) {

		if (count == 2) {
			return 2;
		}

		while (left <= right) {

			if (string.charAt(left) == string.charAt(right)) {
				left++;
				right--;
			} else {
				count = Integer.min(checkPalindrome(string, count + 1, left + 1, right),
						checkPalindrome(string, count + 1, left, right - 1));
				break;
			}
		}

		return count;
	}
}
