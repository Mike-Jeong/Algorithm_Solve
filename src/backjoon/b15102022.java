package backjoon;

import java.io.*;
import java.util.*;

//옥상 정원 꾸미기
//15102022

public class b15102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long ans = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() <= tmp) {
				stack.pop();
			}

			stack.push(tmp);
			ans += stack.size() - 1;
		}

		System.out.println(ans);

	}
}