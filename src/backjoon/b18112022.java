package backjoon;

import java.io.*;
import java.util.*;

//수 이어 쓰기 2
//18112022

public class b18112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long target = 0;
		long numLen = 1;
		long numCnt = 9;

		while (k > numCnt * numLen) {
			k -= (numLen * numCnt);
			target += numCnt;

			numLen++;
			numCnt *= 10;
		}

		target = (target + 1) + (k - 1) / numLen;

		if (target > n) {
			System.out.println(-1);
		} else {
			int idx = (int) ((k - 1) % numLen);
			System.out.println(String.valueOf(target).charAt(idx));
		}
	}
}