package backjoon;

import java.io.*;
import java.util.*;

//크림 파스타
//19062022

public class b19062022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = 0;

        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < dp.length; i++) {

            int current = Integer.parseInt(st.nextToken());  

            min = Math.min(min, current);

            max = Math.max(max, current - min);

            dp[i] = max;


            sb.append(dp[i]);

            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}

/*   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int before = -1;

        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < dp.length; i++) {

            int current = Integer.parseInt(st.nextToken());  

            if (current < min && current < before) {
                dp[i] = dp[i-1];
                min = current;
                before = current;
                max = current;
                sb.append(dp[i] + " ");
                continue;
            }
            
            if (current < min) {
                min = current;
            }

            if (current > max) {
                max = current;
            }

            dp[i] = max - min;
            before = current;

            sb.append(dp[i] + " ");

            if (i != n - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }*/