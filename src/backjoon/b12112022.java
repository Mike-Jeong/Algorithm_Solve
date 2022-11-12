package backjoon;

import java.io.*;
import java.util.*;

//듣보잡
//12112022

public class b12112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> notHear = new HashSet<>();
		for (int i = 0; i < n; i++) {
			notHear.add(br.readLine());
		}

		Queue<String> ans = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {

			String notSeen = br.readLine();
			if (notHear.contains(notSeen)) {
				ans.add(notSeen);
			}
		}

		System.out.println(ans.size());
		while (!ans.isEmpty()) {
			System.out.println(ans.poll());
		}

	}
}
