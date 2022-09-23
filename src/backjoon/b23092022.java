package backjoon;

import java.io.*;
import java.util.*;

//기타 레슨
//23092022

public class b23092022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] lecs = new int[n];

		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lecs.length; i++) {
			lecs[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, lecs[i]);
			right += lecs[i];
		}

		while (left <= right) {
			int mid = (left + right) / 2;

			int count = 1;
			int size = 0;
			for (int i = 0; i < lecs.length; i++) {
				if (size + lecs[i] <= mid) {
					size += lecs[i];
				} else {
					size = lecs[i];
					count++;
				}
			}

			if (count <= m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);

	}
}