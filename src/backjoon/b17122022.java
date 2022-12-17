package backjoon;

import java.io.*;
import java.util.*;

//소수
//17122022

public class b17122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[n + 1];

		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) {
				continue;
			}
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = m; i <= n; i++) {
			if (prime[i] == false) {
				sum += i;
				if (min == Integer.MAX_VALUE) {
					min = i;
				}
			}
		}

		if (sum == 0) { // 소수가 없다면
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}
}