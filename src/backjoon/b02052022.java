package backjoon;

import java.io.*;
import java.util.*;

//1로 만들기
//02052022

public class b02052022 {

	static int count = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		int num = in.nextInt();

		recursion(num, 0);

		System.out.println(count);

		in.close();

	}

	static void recursion(int num, int c) {

		if (num == 1) {

			if (c < count) {
				count = c;
			}

			return;
		}

		if (num % 3 == 0) {
			recursion(num/3, c + 1);
		}

		if (num % 2 == 0) {
			recursion(num/2, c + 1);
		}

		recursion(num - 1, c + 1);
	}
}

//dp로 해결해야함... 다시 풀것
