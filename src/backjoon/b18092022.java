package backjoon;

import java.io.*;
import java.util.*;

//회의실 배정
//18092022

public class b18092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] timeTable = new int[n][2];

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());

			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(timeTable, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}

		});

		int ans = 0;
		int prev = 0;

		for (int i = 0; i < n; i++) {
			if (prev <= timeTable[i][0]) {
				prev = timeTable[i][1];
				ans++;
			}
		}

		System.out.println(ans);
	}
}