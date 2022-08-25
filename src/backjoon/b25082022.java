package backjoon;

import java.io.*;
import java.util.*;

//동작 그만. 밑장 빼기냐? 
//25082022

public class b25082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n / 2 + 1];

        for (int i = 0; i < n; i++) {
            if ((i + 1) % 2 == 0) {
                dp[0][i / 2 + 1] = dp[0][i / 2] + cards[i];
            } else {
                dp[1][i / 2 + 1] = dp[1][i / 2] + cards[i];
            }
        }

        int max = 0;
        int[] results = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            int idx = i / 2 + 1;

            if (i % 2 == 0) {
                results[i] = dp[1][idx - 1] + (dp[0][n / 2 - 1] - dp[0][idx - 2]);
            } else {
                results[i] = dp[1][idx - 1] + (dp[0][n / 2 - 1] - dp[0][idx - 1]) + cards[n - 1];
            }

            max = Math.max(results[i], max);

        }

        System.out.println(max);

    }
}
