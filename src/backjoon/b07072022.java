package backjoon;

import java.io.*;
import java.util.*;

//지름길
//07072022

public class b07072022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[m + 1];

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (start >= m || end > m) {
                continue;
            }

            if (!map.containsKey(start)) {
                map.put(start, new HashMap<Integer, Integer>());
            }

            Map<Integer, Integer> ck = map.get(start);

            if (ck.containsKey(end)) {
                ck.replace(end, Math.min(weight, ck.get(end)));
            } else {
                ck.put(end, weight);
            }
        }

        Arrays.fill(dp, -1);

        for (int i = 0; i < dp.length; i++) {

            if (i == 0) {
                dp[0] = 0;
            } else {
                if (dp[i] != -1) {
                    dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
                } else {
                    dp[i] = dp[i - 1] + 1;
                }

            }

            if (map.containsKey(i)) {

                Map<Integer, Integer> ck = map.get(i);

                for (int j : ck.keySet()) {
                    dp[j] = ck.get(j) + dp[i];
                }

            }
            System.out.println("------------------");
            System.out.println(dp[i]);
            System.out.println(i);
        }
        

        //System.out.println(dp[m]);

    }

}
