package backjoon;

import java.io.*;
import java.util.*;

//격자상의 경로
//26062022

public class b26062022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        if (target == 0) {

            int[][] dp = new int[n][m];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }

            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            System.out.println(dp[n - 1][m - 1]);

        } else {

            int[][] dp = new int[n + 1][m + 1];

            dp[0][1] = 1;

            int r = 0;
            int c = 0;

            int num = 1;

            loop: for (int i = 1; i < dp.length; i++) {

                for (int j = 1; j < dp[i].length; j++) {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                    if (num == target) {
                        r = i;
                        c = j;
                        break loop;
                    }

                    num++;
                }
            }

            for (int i = r + 1; i < dp.length; i++) {
                dp[i][c] = 1;
            }

            for (int i = c + 1; i < dp[0].length; i++) {
                dp[r][i] = 1;
            }

            for (int i = r + 1; i < dp.length; i++) {
                for (int j = c + 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            System.out.println(dp[r][c] * dp[n][m]);
        }

    }

}