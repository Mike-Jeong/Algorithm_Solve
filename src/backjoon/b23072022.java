package backjoon;

import java.io.*;
import java.util.*;

//창영이와 커피
//23072022

public class b23072022 {

    static int[] dp;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        Arrays.fill(dp, 1000000000);

        dp[0] = 0;
        st = new StringTokenizer(br.readLine());

        while (n > 0) {

            int c = Integer.parseInt(st.nextToken());

            for (int i = k; i >= c; i--) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }

            n--;
        }

        if (dp[k] == 1000000000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
        
    }
}

//방법 수 구하기

/*public class b23072022 {

    static int[][] dp;

    public static void draw() {

        System.out.println("-------------------------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] caf = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            caf[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (caf[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (caf[i] == j) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - caf[i]];
                    }
                }
                draw();
            }
        }
    }
}*/