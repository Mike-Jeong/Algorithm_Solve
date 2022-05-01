package backjoon;

import java.io.*;
//import java.util.*;


//소트인사이트
//01052022

public class b01052022 {
	public static void main(String[] args) throws IOException {

		int num = 2143;

		ArrayList<Integer> nums = new ArrayList<>();

		while (num > 0) {
			nums.add(num%10);
			num /= 10;	
		}

		Collections.sort(nums, Collections.reverseOrder());

		for (int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i));
		}
	}
}
