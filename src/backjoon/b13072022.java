package backjoon;

import java.io.*;
import java.util.*;

//랜선 자르기
//13072022

public class b13072022 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] lenght = new int[n];

        long right = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lenght[i] = Integer.parseInt(st.nextToken());

            right = Math.max(right, lenght[i]);
        }

        long left = 1;
        long mid = 0;

        while (left <= right) {

            long count = 0;
            mid = (left + right) / 2;

            for (int i = 0; i < lenght.length; i++) {
                count += (lenght[i] / mid);
            }

            if (count < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);

    }
}