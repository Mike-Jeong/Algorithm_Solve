package backjoon;

import java.io.*;
import java.util.*;

//이중 우선순위 큐
//28112022

public class b28112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			TreeMap<Integer, Integer> treeMap = new TreeMap<>();

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());

				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (command.equals("I")) {
					treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
				} else {
					if (treeMap.isEmpty()) {
						continue;
					} else {
						if (num == -1) {
							if (treeMap.get(treeMap.firstKey()) > 1) {
								treeMap.put(treeMap.firstKey(), treeMap.get(treeMap.firstKey()) - 1);
							} else {
								treeMap.remove(treeMap.firstKey());
							}
						} else {
							if (treeMap.get(treeMap.lastKey()) > 1) {
								treeMap.put(treeMap.lastKey(), treeMap.get(treeMap.lastKey()) - 1);
							} else {
								treeMap.remove(treeMap.lastKey());
							}
						}
					}
				}
			}

			System.out.println(treeMap.isEmpty() ? "EMPTY" : treeMap.lastKey() + " " + treeMap.firstKey());
		}
	}
}
