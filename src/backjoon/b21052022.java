package backjoon;

import java.io.*;
import java.util.*;

//쇠막대기
//21052022

public class b21052022 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		String pipes = sc.nextLine();

		Stack<Integer> st = new Stack<>();

		int ans = 0;

		for (int i = 0; i < pipes.length(); i++) {
			if (pipes.charAt(i) == '(') {
				st.push(1);
			} else {
				if (pipes.charAt(i - 1) == '(') {
					st.pop();
					ans += st.size();
				} else {
					st.pop();
					ans++;
				}
			}
		}

		System.out.println(ans);

		sc.close();

	}
}