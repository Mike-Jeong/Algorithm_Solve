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
		System.out.println("max = " + max);
		while (left <= right) {
			System.out.println("------------------------------------------");
			System.out.println("left = " + left);
			System.out.println("right = " + right);
			int mid = (left + right) / 2;
			System.out.println("mid = " + mid);
			int sum = 0;

			for (int i = 0; i < request.length; i++) {
				if (request[i] > mid) {
					sum += mid;
					System.out.println("sum += " + mid);
				} else {
					sum += request[i];
					System.out.println("sum += " + request[i]);
				}
			}
			System.out.println("sum = " + sum);
			if (sum <= max) {
				left = mid + 1;
			} else{
				right = mid - 1;
			}
		}
		System.out.println("------------------------------------------");
		System.out.println(right);
	}
}
