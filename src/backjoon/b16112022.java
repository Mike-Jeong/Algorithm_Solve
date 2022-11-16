package backjoon;

import java.io.*;
import java.util.*;

//나3곱2
//16112022

public class b16112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long bigNum = -1;
		Set<Long> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			long current = Long.parseLong(st.nextToken());
			set.add(current);
			bigNum = Math.max(current, bigNum);
		}

		LinkedList<Long> list = new LinkedList<>();
		list.add(bigNum);

		long cur = bigNum;
		while (true) {
			if (cur % 3 == 0 && set.contains(cur / 3)) {
				cur /= 3;
				list.addLast(cur);
			} else if (set.contains(cur * 2)) {
				cur *= 2;
				list.addLast(cur);
			} else {
				break;
			}
		}

		cur = bigNum;
		while (true) {

			if (list.size() == n) {
				break;
			}

			if (cur % 2 == 0 && set.contains(cur / 2)) {
				cur /= 2;
				list.addFirst(cur);
			} else if (set.contains(cur * 3)) {
				cur *= 3;
				list.addFirst(cur);
			} else {
				break;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}