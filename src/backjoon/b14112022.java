package backjoon;

import java.io.*;
import java.util.*;

//회사에 있는 사람
//14112022

public class b14112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String command = st.nextToken();

			if (command.equals("leave")) {
				set.remove(name);
			} else {
				set.add(name);
			}

		}

		String[] peo = set.stream().toArray(String[]::new);

		Arrays.sort(peo);

		for (int i = peo.length - 1; i >= 0; i--) {
			System.out.println(peo[i]);
		}

	}
}
