package backjoon;

import java.io.*;
import java.util.*;

//동전
//07082022

public class b07082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numTest = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numTest; i++) {

            st = new StringTokenizer(br.readLine());

            int numCoin = Integer.parseInt(st.nextToken());

            int[] coins = new int[numCoin];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numCoin; j++) {

                int coinValue = Integer.parseInt(st.nextToken());
                coins[i] = coinValue;

            }

            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());

            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int j = 0; j < coins.length; j++) {
                for (int j2 = coins[i]; j2 <= target; j2++) {
                    dp[j2] = dp[j2 - coins[i]];
                }
            }

            System.out.println(dp[target]);
            
        }

        
    }
}
