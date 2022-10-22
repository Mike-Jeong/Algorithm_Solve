package backjoon;

import java.io.*;
import java.util.*;

//제로
//22102022

public class b22102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				stack.pop();
				continue;
			}

			stack.add(num);
		}

		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}

		System.out.println(ans);
	}

}