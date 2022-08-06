package backjoon;

import java.io.*;
import java.util.*;

//타일 채우기
//06082022

public class b06082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        if (n % 2 == 0) {

            dp[0] = 1;
            dp[2] = 3;

            for (int i = 4; i <= n; i += 2) {

                dp[i] = dp[i - 2] * dp[2];

                for (int j = i - 4; j >= 0; j -= 2) {

                    dp[i] += dp[j] * 2;
                    
                }
            }

            System.out.println(dp[n]);

        } else {
            System.out.println(0);
        }
    }
}
