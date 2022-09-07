package backjoon;

import java.io.*;
import java.util.*;

//다각형의 면적
//07092022

public class b07092022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        long sum_a = 0, sum_b = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[n] = x[0];
        y[n] = y[0];

        for (int i = 0; i < n; i++) {
            sum_a += x[i] * y[i + 1];
            sum_b += x[i + 1] * y[i];
        }

        System.out.println(String.format("%.1f", (Math.abs(sum_a - sum_b) / 2.0)));

    }
}
//신발끈 공식 이용