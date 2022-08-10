package backjoon;

import java.io.*;
import java.util.*;

//동전 2
//10082022

public class b10082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
       
    }
}
