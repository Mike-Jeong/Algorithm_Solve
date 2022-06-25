package backjoon;

import java.io.*;
import java.util.*;

//병사 배치하기
//24062022

public class b24062022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        int[] num = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 1; i < dp.length; i++) {

            dp[i] = 1;
            num[i] = Integer.parseInt(st.nextToken());

            for (int j = i - 1; j >= 1; j--) {

                if (num[i] < num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

            if (dp[i] > max) {
                max = dp[i];
            }

        }

        System.out.println(n - max);

    }

}