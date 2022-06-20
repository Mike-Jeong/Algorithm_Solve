package backjoon;

import java.io.*;
import java.util.*;

//이동하기
//21062022

public class b21062022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1]));
            }
        }

        System.out.println(dp[n][m]);

    }

   
}