package backjoon;

import java.io.*;
import java.util.*;

//최대공약수
//02122022

public class b02122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long gcd = findGCD(Math.max(a, b), Math.min(a, b));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < gcd; i++) {
			// System.out.print("1");
			sb.append("1");
		}

		System.out.println(sb);

	}

	private static long findGCD(long a, long b) {
		while (b > 0) {
			long tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
}
