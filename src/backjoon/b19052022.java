package backjoon;

import java.io.*;
import java.util.*;

//N과 M(4)
//19052022

public class b19052022 {

	public static int N, M;
	public static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		recursion(1, 0);
		System.out.println(sb);

	}

	public static void recursion(int index, int depth) {

		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = index; i <= N; i++) {
			arr[depth] = i;
			recursion(i, depth + 1);
		}

	}
}