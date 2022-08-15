package backjoon;

import java.io.*;
import java.util.*;

//로봇 프로젝트
//15082022

public class b15082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while ((s = br.readLine()) != null) {

            int x = Integer.parseInt(s) * 10000000;

            int n = Integer.parseInt(br.readLine());

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(nums);

            if (n > 1) {
                int left = 0;
                int right = n - 1;

                while (left < right) {

                    int sum = nums[left] + nums[right];

                    if (sum == x) {
                        break;
                    } else if (sum < x) {
                        left++;
                    } else {
                        right--;
                    }
                }

                if (left == right) {
                    System.out.println("danger");
                } else {
                    System.out.println("yes " + nums[left] + " " + nums[right]);
                }
            } else {
                System.out.println("danger");
            }

            s = null;
        }
    }
}