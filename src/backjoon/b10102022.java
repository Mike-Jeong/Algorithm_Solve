package backjoon;

import java.io.*;
import java.util.*;

//PPAP
//10102022

public class b10102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String s = br.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);

			if (temp == 'P')
				stack.push('P');

			else {
				if (stack.size() >= 2 && i < s.length() - 1 && s.charAt(i + 1) == 'P') {
					stack.pop();
					stack.pop();
				} else {
					System.out.println("NP");
					return;
				}
			}
		}
		if (stack.size() == 1) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}

	}
}
