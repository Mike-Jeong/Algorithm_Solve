package backjoon;

import java.io.*;
import java.util.*;

//수들의 합 4
//26052022

public class b26052022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] nums = new int[num + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());    
        }

        for (int i = 1; i < nums.length; i++) {

            int sum = nums[i];

            for (int j = i - 1; j > -1; j--) {

                int now = sum - nums[j];

                if (now >= target) {
                    if (now == target) {
                        count++;
                    }
                    break;
                }
            }
        }

        System.out.println(count);
    }

}