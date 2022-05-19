package backjoon;

import java.io.*;
import java.util.*;

//N과 M(3)
//19052022

public class b19052022 {

	static int N;
	static int target;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		nums = new int[target];

		recursion(0);

		System.out.println(sb);

	}

	public static void recursion(int index) {

	
	}
}