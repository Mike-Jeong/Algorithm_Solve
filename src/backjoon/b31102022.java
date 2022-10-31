package backjoon;

import java.io.*;
import java.util.*;

//플로이드
//31102022

public class b31102022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				int init = (i == j) ? 0 : 987654321;

				dp[i][j] = init;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			dp[d][a] = Math.min(Integer.parseInt(st.nextToken()), dp[d][a]);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int j2 = 1; j2 <= n; j2++) {
					if (dp[j][j2] > dp[j][i] + dp[i][j2]) {
                        dp[j][j2] = dp[j][i] + dp[i][j2];
                    }
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                
				int num = (dp[i][j] == 987654321) ? 0 : dp[i][j];
 
                sb.append(num + " ");
            }
            sb.append("\n");
        }

		System.out.println(sb.toString());

	}
}