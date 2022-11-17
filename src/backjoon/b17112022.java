package backjoon;

import java.io.*;
import java.util.*;

//그룹 단어 체커
//17112022

public class b17112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int ans = 0;

		for (int i = 0; i < n; i++) {

			String current = br.readLine();

			Set<Character> set = new HashSet<>();

			for (int j = 0; j < current.length(); j++) {
				if (!set.contains(current.charAt(j))) {
					set.add(current.charAt(j));
				} else if (set.contains(current.charAt(j)) && current.charAt(j - 1) != current.charAt(j)) {
					break;
				}

				if (j == current.length() - 1) {
					ans++;
				}

			}
		}

		System.out.println(ans);
	}
}