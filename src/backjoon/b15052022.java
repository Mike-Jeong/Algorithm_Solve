package backjoon;

import java.io.*;
import java.util.*;

//N과 M (2)
//15052022

public class b15052022 {

	static int range;
	static int target;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		range = Integer.valueOf(st.nextToken());
		target = Integer.valueOf(st.nextToken());

		recursion(1, 0, "");

	}

	public static void recursion(int index, int count, String ans) {

		if (count == target) {
			System.out.println(ans.trim());
			return;
		}

		for (int i = index; i < range + 1; i++) {

				String s = ans + i + " ";
				recursion(i + 1, count + 1, s);
			
		}
	}
}