package backjoon;

import java.io.*;
import java.util.*;

//무한 수열
//18102022

public class b18102022 {

	static long n;
	static long p;
	static long q;
	static Map<Long,Long> map = new HashMap<>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());

		map.put(0L, 1L);

		System.out.println(recursion(n));
	}

	public static long recursion(long index) {

		if (map.containsKey(index)) {
			return map.get(index);
		}

		map.put(index, recursion(index / p) + recursion(index / q));

		return map.get(index);
	}
}