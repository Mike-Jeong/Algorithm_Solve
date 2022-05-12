package backjoon;

import java.io.*;
import java.util.*;

//2×n 타일링 2
//12052022

public class b12052022 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
        } else {

            int[] nums = new int[N + 1];

            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 3;
    
            for (int i = 3; i < nums.length; i++) {
                nums[i] = (nums[i - 1] + nums[i - 2] * 2) % 10007;
            }
    
            System.out.println(nums[N]);
    

        }

        sc.close();

    }

}
