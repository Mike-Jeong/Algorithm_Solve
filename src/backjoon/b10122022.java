package backjoon;

import java.io.*;
import java.util.*;

//두 배열의 합
//10122022

public class b10122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] array1 = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array1[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list1 = new ArrayList<>();

		for (int i = n - 1; i >= 0; i--) {

			list1.add(array1[i]);

			int temp = 0;
			for (int j = i - 1; j >= 0; j--) {
				temp += array1[j];
				list1.add(array1[i] + temp);
			}
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[] array2 = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			array2[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list2 = new ArrayList<>();

		for (int i = m - 1; i >= 0; i--) {

			list2.add(array2[i]);

			int temp = 0;
			for (int j = i - 1; j >= 0; j--) {
				temp += array2[j];
				list2.add(array2[i] + temp);
			}
		}

		Collections.sort(list1);
		Collections.sort(list2, Collections.reverseOrder());

		int count = 0;
		for (int i = 0; i < list1.size(); i++) {
			
			for (int j = 0; j < list2.size(); j++) {

				if (list1.get(i) + list2.get(j) == t) {
					count++;
				}

				if (list1.get(i) + list2.get(j) < t) {
					break;
				}
			}
		}

		System.out.println(count);

	}
}