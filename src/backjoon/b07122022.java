package backjoon;

import java.io.*;
import java.util.*;

//세 용액
//07122022

public class b07122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] liquid = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);

		int[] ans = new int[3];
		long max = Long.MAX_VALUE;

		loop:    
		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n- 1;

			while (left < right) {
				
				long sum = liquid[left] + liquid[right] + liquid[i];
				long diff = Math.abs(sum);

				if (sum == 0) {
					ans[0] = liquid[i];
					ans[1] = liquid[left];
					ans[2] = liquid[right];
					break loop;
				}

				if (max > diff) {
					ans[0] = liquid[i];
					ans[1] = liquid[left];
					ans[2] = liquid[right];
					max = diff;
				}

				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}

		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}


