package backjoon;

import java.io.*;
import java.util.*;

//친구 네트워크
//22122022

public class b22122022 {

	static Map<String, String> parents;
	static Map<String, Integer> count;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());

			parents = new HashMap<>();
			count = new HashMap<>();

			for (int j = 0; j < f; j++) {
				st = new StringTokenizer(br.readLine());

				String people1 = st.nextToken();
				String people2 = st.nextToken();

				if (!parents.containsKey(people1)) {
					parents.put(people1, people1);
					count.put(people1, 1);
				}

				if (!parents.containsKey(people2)) {
					parents.put(people2, people2);
					count.put(people2, 1);
				}

				

				if (!find(people1).equals(find(people2))) {
					sb.append(find(people1) + " " + find(people2)).append("시작 :   \n");
					union(people1, people2);
				}
				sb.append(find(people1) + " " + find(people2)).append("\n");
			}
		}

		System.out.println(sb);

	}

	static void union(String x, String y) {

		String[] people = new String[2];

		people[0] = find(x);
		people[1] = find(y);

		Arrays.sort(people);

		count.replace(people[0], count.get(people[0]) + count.get(people[1]));

		parents.replace(people[1], people[0]);

		//sb.append(count.get(people[0])).append("\n");

	}

	static String find(String x) {

		if (parents.get(x).equals(x)) {
			return x;
		}

		return parents.replace(x, find(parents.get(x)));
	}

}