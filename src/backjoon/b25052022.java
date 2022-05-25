package backjoon;

import java.io.*;
import java.util.*;

//구간 합 구하기 4
//25052022

public class b25052022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer("");

        int num = Integer.parseInt(st.nextToken());
        int iter = Integer.parseInt(st.nextToken());

        int[] nums = new int[num + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < iter; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = nums[end] - nums[start - 1];

            sb.append(count + "\n");
        }

        System.out.println(sb);

    }

}