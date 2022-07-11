package backjoon;

import java.io.*;
import java.util.*;

//녹색 옷 입은 애가 젤다지?
//11072022

public class b11072022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] rOrder = new int[] { -1, 0, 1, 0 };
        int[] cOrder = new int[] { 0, -1, 0, 1 };

        int count = 0;
        while (true) {
            count++;
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            int[][] map = new int[n][n];
            int[][] dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { 0, 0 });
            dp[0][0] = map[0][0];

            while (!queue.isEmpty()) {
               
                int[] current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    try {
                        if (dp[current[0] + rOrder[i]][current[1] + cOrder[i]] > (dp[current[0]][current[1]]
                                + map[current[0] + rOrder[i]][current[1] + cOrder[i]])) {
                            dp[current[0] + rOrder[i]][current[1] + cOrder[i]] = (dp[current[0]][current[1]]
                                    + map[current[0] + rOrder[i]][current[1] + cOrder[i]]);
                            queue.add(new int[] { (current[0] + rOrder[i]), (current[1] + cOrder[i]) });
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }

            }

            System.out.println("Problem " + count + ": " + dp[n - 1][n - 1]);
            
        }

    }
}
