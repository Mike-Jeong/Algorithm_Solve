package backjoon;

import java.io.*;
import java.util.*;

//입국심사
//19082022

public class b19082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[n - 1] * m;

        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;

            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }

            if (count < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }

        }

        System.out.println(answer);

    }
}