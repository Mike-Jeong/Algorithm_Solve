package backjoon;

import java.io.*;
import java.util.*;

//다이어트
//21102022

public class b21102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int g = Integer.parseInt(st.nextToken());

		boolean find = false;

		for (int k = (int) Math.sqrt(g); k >= 1; --k) {

			if (g % k != 0) {
				continue;
			}

			int v = g / k;

			if ((v + k) % 2 != 0 || (v - k) / 2 == 0) {
				continue;
			}

			find = true;
			System.out.println((v + k) / 2);

		}

		if (!find) {
			System.out.println(-1);
		}
	}

}