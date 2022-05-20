package backjoon;

import java.io.*;
import java.util.*;

//01타일
//20052022

public class b20052022 {

	public static int N, M;
	public static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int[] nums = new int[num + 1];

		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;

		for (int i = 3; i < nums.length; i++) {
			nums[i] = (nums[i - 1] + nums[i - 2]) / 15746;
		}

		System.out.println(nums[num]);

		sc.close();

	}
}