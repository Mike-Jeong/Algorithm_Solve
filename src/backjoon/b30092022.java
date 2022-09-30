package backjoon;

import java.io.*;
import java.util.*;

//소수팰린드롬
//30092022

public class b30092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[b + 1];

		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i * i <= b; i++) {
			if (!isPrime[i]) {
				for (int j = i * i; j <= b; j += i) {
					isPrime[j] = true;
				}
			}
		}

		for (int i = a; i <= b; i++) {
			if (!isPrime[i]) {
				String t = String.valueOf(i);
				boolean isPalindrome = true;

				for (int j = 0; j < t.length() / 2; j++) {
					if (t.charAt(j) != t.charAt(t.length() - j - 1)) {
						isPalindrome = false;
						break;
					}
				}

				if (isPalindrome) {
					System.out.println(i);
				}
			}
		}

		System.out.println(-1);
	}
}