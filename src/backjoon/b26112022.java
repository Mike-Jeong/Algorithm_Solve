package backjoon;

import java.io.*;
import java.util.*;

//괄호의 값
//26112022

public class b26112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String string = br.readLine();

		Stack<Character> stack = new Stack<>();

		boolean isValid = true;
		int answer = 0;
		int temp = 1;

		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) == '(') {
				temp *= 2;
				stack.add(')');
			} else if (string.charAt(i) == '[') {
				temp *= 3;
				stack.add(']');
			} else {
				if (stack.isEmpty() || stack.peek() != string.charAt(i)) {
					isValid = false;
					break;
				}

				if (string.charAt(i - 1) == '(') {
					answer += temp;
				}

				if (string.charAt(i - 1) == '[') {
					answer += temp;
				}

				int division = stack.peek() == ')' ? 2 : 3;
				temp /= division;

				stack.pop();

			}
		}

		System.out.println(isValid || !stack.isEmpty() ? answer : 0);

	}
}
