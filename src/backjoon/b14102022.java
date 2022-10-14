package backjoon;

import java.io.*;
import java.util.*;

//괄호
//14102022

public class b14102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		loop:
		for (int i = 0; i < n; i++) {

			String input = br.readLine();

			int check = 0;
			boolean isVPS = true;

			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '(') {
					check++;
				} else {
					if (check == 0) {
						sb.append("NO\n");
						continue loop;
					}
					check--;
				}
			}

			if (isVPS) {
				sb.append(check == 0 ? "YES" : "NO").append("\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb.toString());

	}
}