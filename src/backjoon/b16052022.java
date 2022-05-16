package backjoon;

import java.io.*;
import java.util.*;

//퇴사
//16052022

public class b16052022 {

	static int N;
	static int[] days;
	static int[] profit;
	static int maxProfit = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		days = new int[N];
		profit = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			days[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());

		}

		recursion(0, 0);

		System.out.println(maxProfit);


	}

	public static void recursion(int index, int sum) {

		if (index >= N) {
			if (index == N) {
				maxProfit = Math.max(maxProfit, sum);
			}

			return;
		}

		recursion(index + 1, sum);
		recursion(index + days[index], sum + profit[index]);
		
	}
}