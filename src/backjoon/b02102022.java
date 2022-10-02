package backjoon;

import java.io.*;
import java.util.*;

//제곱 ㄴㄴ 수
//02102022

public class b02102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.valueOf(st.nextToken());
		long max = Long.valueOf(st.nextToken());

		long count = max - min + 1;
		boolean[] prime = new boolean[(int) count];

		for (long i = 2; i * i <= max; i++) {
			long pow = i * i;
			long tmp = min / pow;
			if (min % pow != 0) {
				tmp += 1;
			}

			for (long j = tmp; j * pow <= max; j++) {
				int sqrt = (int) (j * pow - min);
				if (!prime[sqrt]) {
					prime[sqrt] = true;
					count--;
				}
			}
		}
		System.out.println(count);
	}
}