package backjoon;

import java.io.*;
import java.util.*;

//회사 문화 1
//16102022

public class b16102022 {

	static Map<Integer, ArrayList<Integer>> workStruct = new HashMap<>();
	static int[] points;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		points = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			workStruct.put(i, new ArrayList<>());

			int lead = Integer.parseInt(st.nextToken());

			if (lead != -1) {
				workStruct.get(lead).add(i);	
			}

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int worker = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			points[worker] += point;
		}

		recursion(1, points[1]);

		for (int i = 1; i <= n; i++) {
			System.out.print(points[i] + " ");
		}

	}

	public static void recursion(int worker, int point) {

		points[worker] += point;

		List<Integer> list = workStruct.get(worker);

		for (int i = 0; i < list.size(); i++) {
			recursion(list.get(i), points[worker]);
		}

	}
}

/*
public class b16102022 {

	static ArrayList<Integer>[] list;
	static int[] points;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		points = new int[n + 1];
		list = new ArrayList[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();

			int lead = Integer.parseInt(st.nextToken());

			if (lead != -1) {
				list[lead].add(i);
			}

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int worker = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			points[worker] += point;
		}

		recursion(1, points[1]);

		for (int i = 1; i <= n; i++) {
			System.out.print(points[i] + " ");
		}

	}

	public static void recursion(int worker, int point) {

		points[worker] += point;

		for (int i = 0; i < list[worker].size(); i++) {
			recursion(list[worker].get(i), points[worker]);
		}

	}
}
 */