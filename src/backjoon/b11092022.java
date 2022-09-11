package backjoon;

import java.io.*;
import java.util.*;

//스택
//11092022

public class b11092022 {

	static Stack<Integer> stack = new Stack<>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {

			String string = br.readLine();

			order(string);
		}

	}

	static void order(String order) {

		String[] orders = order.split(" ");
		int result;

		switch (orders[0]) {
			case "push":
				stack.push(Integer.parseInt(orders[1]));
				break;
			case "pop":
				result = stack.isEmpty() ? -1 : stack.pop();
				System.out.println(result);
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				result = stack.isEmpty() ? 1 : 0;
				System.out.println(result);
				break;
			case "top":
				result = stack.isEmpty() ? -1 : stack.peek();
				System.out.println(result);
				break;

			default:
				break;
		}
	}
}