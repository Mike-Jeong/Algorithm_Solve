package backjoon;

import java.io.*;
import java.util.*;

//예산
//04072022

public class b04072022 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] request = new int[n];

		int left = 0;
		int right = 0;

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < request.length; i++) {

			
			request[i] = Integer.parseInt(st.nextToken());

			right = Math.max(right, request[i]);
		}

		st = new StringTokenizer(br.readLine());

		int max = Integer.parseInt(st.nextToken());

		while (left <= right) {

			int mid = (left + right) / 2;

			int sum = 0;

			for (int i = 0; i < request.length; i++) {
				if (request[i] > mid) {
					sum += mid;
				} else {
					sum += request[i];
				}
			}

			if (sum <= max) {
				left = mid + 1;
			} else{
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}
