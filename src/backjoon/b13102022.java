package backjoon;

import java.io.*;
import java.util.*;

//크게 만들기
//13102022

public class b13102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String num = br.readLine();

		Stack<Character> stack = new Stack<>();

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!stack.isEmpty() && stack.peek() < num.charAt(i)) {

				while (!stack.isEmpty() && count < k && stack.peek() < num.charAt(i)) {
					// System.out.println("pop" + stack.pop());
					stack.pop();
					count++;
				}

			}
			stack.push(num.charAt(i));
		}

		int ans = 0;
		int pow = 0;

		if (stack.size() > (n - k)) {
			while (stack.size() != (n - k)) {
				stack.pop();
			}
		}

		while (!stack.isEmpty()) {
			ans += (stack.pop() - 48) * (int) Math.pow(10, pow);
			pow++;
		}

		System.out.println(ans);
	}
}