package backjoon;

import java.io.*;
import java.util.*;

//가장 큰 증가 부분 수열
//22062022

public class b22062022 {

    static int dp[], cost[];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp = new int[n + 1];
        cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            cost[i] = sc.nextInt();
        }

        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i];
            for (int j = 1; j < i; j++) {
                if (cost[i] > cost[j]) {
                    dp[i] = Math.max(dp[j] + cost[i], dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);

        sc.close();

    }

}