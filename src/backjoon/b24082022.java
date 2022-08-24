package backjoon;

import java.io.*;
import java.util.*;

//꿀 따기 
//24082022

public class b24082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] honey = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < sum.length; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + honey[i];
        }

        int max = 0;

        for (int i = 2; i <= n - 1; i++) {
            int ck = sum[n] - honey[1] - honey[i] + sum[n] - sum[i];
            max = Math.max(max, ck);
        }

        for (int i = 2; i <= n - 1; i++) {
            int ck = sum[n - 1] - sum[i - 1] + sum[i] - sum[1];
            max = Math.max(max, ck);
        }

        for (int i = 2; i <= n - 1; i++) {
            int ck = sum[n - 1] - honey[i] + sum[i - 1];
            max = Math.max(max, ck);
        }

        System.out.println(max);

    }
}