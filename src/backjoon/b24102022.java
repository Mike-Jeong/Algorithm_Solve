package backjoon;

import java.io.*;
import java.util.*;

//무한 수열 2
//24102022

public class b24102022 {

	static long n;
	static int p;
	static int q;
	static int x;
	static int y;
	static Map<Long, Long> map = new HashMap<>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());

		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		System.out.println(recursion(n));
	}

	public static long recursion(long index) {

		if (index <= 0) {
			return 1;
		}

		if (map.containsKey(index)) {
			return map.get(index);
		}

		map.put(index, recursion((index / p) - x) + recursion((index / q) - y));

		return map.get(index);
	}
}