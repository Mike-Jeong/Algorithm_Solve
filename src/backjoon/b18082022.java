package backjoon;

import java.io.*;
import java.util.*;

//용액
//18082022

public class b18082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] liq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < liq.length; i++) {
            liq[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;

        int s = 0;
        int e = 0;

        while (start < end) {
            int sum = Math.abs(liq[start] + liq[end]);
            if (sum < min) {
                min = sum;
                s = start;
                e = end;
            }
            if (sum == 0)
                break;

            if (liq[start] + liq[end] > 0) {
                end--;
            } else {
                start++;
            }
        }
        
        System.out.println(liq[s] + " " + liq[e]);
    }
}