package backjoon;

import java.io.*;
import java.util.*;

//내려가기
//15072022

public class b15072022 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] maxDp = new int[3];
		int[] minDp = new int[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxDp[0] = minDp[0] = n1;
				maxDp[1] = minDp[1] = n2;
				maxDp[2] = minDp[2] = n3;
			} else {

				int beforeMaxDp_0 = maxDp[0], beforeMaxDp_2 = maxDp[2];
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + n1;
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + n3;
				maxDp[1] = Math.max(Math.max(beforeMaxDp_0, maxDp[1]), beforeMaxDp_2) + n2;

				int beforeMinDp_0 = minDp[0], beforeMinDp_2 = minDp[2];
				minDp[0] = Math.min(minDp[0], minDp[1]) + n1;
				minDp[2] = Math.min(minDp[1], minDp[2]) + n3;
				minDp[1] = Math.min(Math.min(beforeMinDp_0, minDp[1]), beforeMinDp_2) + n2;
			}
		}

		System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " " + Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
	}
}