package backjoon;

import java.io.*;
//import java.util.*;

//셀프넘버
//30042022

public class b30042022 {
	public static void main(String[] args) throws IOException {

		boolean[] nums = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {

			int n = i;

			while (n <= 10000) {

				int cur = 0;
				cur += n;
				while (n > 0) {
					cur += (n % 10);
					n /= 10;
				}

				if (cur <= 10000) {
					nums[cur] = true;
				}

				n = cur;
			}

			if (!nums[i]) {
				System.out.println(i);
			}

		}

	}
}
