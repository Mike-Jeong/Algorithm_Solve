package backjoon;

import java.io.*;
import java.util.*;

//소트인사이트
//01052022

public class b01052022 {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		int num = in.nextInt();

		ArrayList<Integer> nums = new ArrayList<>();

		while (num > 0) {
			nums.add(num % 10);
			num /= 10;
		}

		Collections.sort(nums, Collections.reverseOrder());

		for (int j = 0; j < nums.size(); j++) {
			System.out.print(nums.get(j));
		}
		System.out.print("\n");

		in.close();

	}
}
