package backjoon;

import java.io.*;
import java.util.*;

//수 찾기
//26102022

public class b26102022 {

	static Set<Integer> nums =  new HashSet<>();
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			System.out.println(nums.contains(target) ? "1" : "0");
		}
	}
}