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

		long count = 0;
		int index1 = 0;
		int index2 = 0;

		while (index1 < list1.size() && index2 < list2.size()) {

			int a = list1.get(index1);
			int b = list2.get(index2);
			int sum = a + b;

			if (sum == t) {
				long aCount = 0;
				long bCount = 0;

				while (index1 < list1.size() && list1.get(index1) == a) {
					aCount++;
					index1++;
				}

				while (index2 < list2.size() && list2.get(index2) == b) {
					bCount++;
					index2++;
				}

				count += (aCount * bCount);

			} else if (sum < t) {
				index1++;
			} else if (sum > t) {
				index2++;
			}
		}

		System.out.println(count);

	}
}