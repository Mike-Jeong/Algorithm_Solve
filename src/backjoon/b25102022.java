package backjoon;

import java.io.*;
import java.util.*;

//기타줄
//25102022

public class b25102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int ans = Integer.MAX_VALUE;

		int[] unit = new int[m];
		int[] pack = new int[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(unit);
		Arrays.sort(pack);

		ans = Math.min(((n / 6) + 1) * pack[0], n * unit[0]);
		ans = Math.min(ans, ((n / 6)) * pack[0] + (n % 6) * unit[0]);

		System.out.println(ans);

	}
}