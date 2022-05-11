package backjoon;

import java.io.*;
import java.util.*;

//파도반 수열
//11052022

public class b11052022 {

	static int target;
	static boolean[] nums;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.valueOf(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.valueOf(st.nextToken());
			
		}

		nums = new boolean[N+1];

		target = Integer.valueOf(st.nextToken());

	}
}