package backjoon;

import java.io.*;
import java.util.*;

//두 용액
//12082022

public class b12082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
           nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        
        int s = 0;
        int e = n - 1;
        int min = Integer.MAX_VALUE;

        int ansLeft = 0;
        int ansRight = 0;

        while (s < e) {

            int sum = nums[s]+nums[e];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                ansLeft = nums[s];
                ansRight = nums[e];

                if (sum == 0) {
                    break;
                }

            }

            if (sum < 0) {
                s++;
            } else {
                e--;
            }
        }
        
        System.out.println(ansLeft + " " + ansRight);
    }
}
