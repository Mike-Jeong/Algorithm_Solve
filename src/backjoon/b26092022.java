package backjoon;

import java.io.*;
import java.util.*;

//빗물
//26092022

public class b26092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] heights = new int[w];
		int maxH = -1;
		int maxHIndex = -1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			heights[i] = Integer.parseInt(st.nextToken());

			if (h < heights[i]) {
				System.out.println("문제오류");
			}
			if (maxH < heights[i]) {
				maxH = heights[i];
				maxHIndex = i;
			}
		}

		if (maxH == 0) {
			System.out.println(0);
		} else {

			int ans = 0;

			int left = heights[0];

			for (int i = 1; i < maxHIndex; i++) {
				if (heights[i] > left) {
					left = heights[i];
				} else {
					ans += (left - heights[i]);
				}
			}

			left = heights[w - 1];

			for (int i = heights.length - 2; i > maxHIndex; i--) {
				if (heights[i] > left) {
					left = heights[i];
				} else {
					ans += (left - heights[i]);
				}
			}

			System.out.println(ans);
		}


	}
}