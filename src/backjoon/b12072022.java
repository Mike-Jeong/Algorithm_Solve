package backjoon;

import java.io.*;
import java.util.*;

//특정한 최단 경로
//12072022

public class b12072022 {

    static int[][] map;
    static int[] dp;
    static int sum1 = 0;
    static int sum2 = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[s][e] = w;
            map[e][s] = w;
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        Arrays.fill(dp, 200000000);

        dijkstra(1);

        if (dp[v1] >= 200000000 || dp[v2] >= 200000000 || dp[n] >= 200000000) {
            System.out.println(-1);
        } else {
            sum1 += dp[v1];
            sum2 += dp[v2];
            dp = new int[n + 1];
            Arrays.fill(dp, 200000000);
            dijkstra(v1);
            sum1 += dp[v2];
            sum2 += dp[n];
            dp = new int[n + 1];
            Arrays.fill(dp, 200000000);
            dijkstra(v2);
            sum1 += dp[n];
            sum2 += dp[v1];

            if (sum1 > sum2) {
                System.out.println(sum2);
            } else {
                System.out.println(sum1);
            }

        }

    }

    public static void dijkstra(int start) {

        dp[start] = 0;
        PriorityQueue<N> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new N(start, 0));

        while (!priorityQueue.isEmpty()) {

            N current = priorityQueue.poll();

            for (int i = 1; i < dp.length; i++) {
                if (i != current.end && map[current.end][i] != 0 && dp[i] > dp[current.end] + map[current.end][i]) {
                    dp[i] = dp[current.end] + map[current.end][i];
                    priorityQueue.add(new N(i, dp[i]));
                }
            }
        }
    }
}

class N implements Comparable<N> {

    int end;
    int weight;

    public N(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(N o) {
        return weight - o.weight;
    }
}