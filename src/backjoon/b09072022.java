package backjoon;

import java.io.*;
import java.util.*;

//파티
//09072022

public class b09072022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Node4>> map = new HashMap<>();
        Map<Integer, ArrayList<Node4>> mapReverse = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<Node4>());
            }

            map.get(s).add(new Node4(e, w));

            if (!mapReverse.containsKey(e)) {
                mapReverse.put(e, new ArrayList<Node4>());
            }

            mapReverse.get(e).add(new Node4(s, w));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        PriorityQueue<Node4> priorityQueue = new PriorityQueue<>();
        dp[start] = 0;
        priorityQueue.add(new Node4(start, 0));

        while (!priorityQueue.isEmpty()) {

            Node4 current = priorityQueue.poll();

            if (map.containsKey(current.end)) {

                ArrayList<Node4> list = map.get(current.end);

                for (int i = 0; i < list.size(); i++) {

                    Node4 next = list.get(i);

                    if (dp[next.end] != -1) {
                        if (dp[next.end] > (dp[current.end] + next.weight)) {
                            dp[next.end] = dp[current.end] + next.weight;
                            priorityQueue.add(new Node4(next.end, dp[current.end] + next.weight));
                        }
                    } else {
                        dp[next.end] = dp[current.end] + next.weight;
                        priorityQueue.add(new Node4(next.end, dp[current.end] + next.weight));
                    }
                }
            }
        }

        int[] dpReverse = new int[n + 1];
        Arrays.fill(dpReverse, -1);

        PriorityQueue<Node4> priorityQueueR = new PriorityQueue<>();
        dpReverse[start] = 0;
        priorityQueueR.add(new Node4(start, 0));

        while (!priorityQueueR.isEmpty()) {

            Node4 current = priorityQueueR.poll();

            if (mapReverse.containsKey(current.end)) {

                ArrayList<Node4> list = mapReverse.get(current.end);

                for (int i = 0; i < list.size(); i++) {

                    Node4 next = list.get(i);

                    if (dpReverse[next.end] != -1) {
                        if (dpReverse[next.end] > (dpReverse[current.end] + next.weight)) {
                            dpReverse[next.end] = dpReverse[current.end] + next.weight;
                            priorityQueueR.add(new Node4(next.end, dpReverse[current.end] + next.weight));
                        }
                    } else {
                        dpReverse[next.end] = dpReverse[current.end] + next.weight;
                        priorityQueueR.add(new Node4(next.end, dpReverse[current.end] + next.weight));
                    }
                }
            }
        }

        int[] dpSun = new int[n];

        int max = 0;

        for (int i = 0; i < dpSun.length; i++) {
            dpSun[i] = dp[i + 1] + dpReverse[i + 1];

            if (dpSun[i] > max) {
                max = dpSun[i];
            }
        }
        
        System.out.println(max);
    }
}

class Node4 implements Comparable<Node4> {

    int end;
    int weight;

    public Node4(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node4 o) {
        return weight - o.weight;
    }
}
