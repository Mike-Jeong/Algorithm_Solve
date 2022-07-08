package backjoon;

import java.io.*;
import java.util.*;

//최단경로
//08072022

public class b08072022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Node3>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<Node3>());
            }

            map.get(s).add(new Node3(e, w));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        PriorityQueue<Node3> priorityQueue = new PriorityQueue<>();
        dp[start] = 0;
        priorityQueue.add(new Node3(start, 0));

        while (!priorityQueue.isEmpty()) {

            Node3 current = priorityQueue.poll();

            if (map.containsKey(current.end)) {

                ArrayList<Node3> list = map.get(current.end);

                for (int i = 0; i < list.size(); i++) {

                    Node3 next = list.get(i);

                    if (dp[next.end] != -1) {
                        if (dp[next.end] > (dp[current.end] + next.weight)) {
                            dp[next.end] = dp[current.end] + next.weight;
                            priorityQueue.add(next);
                        }
                    } else {
                        dp[next.end] = dp[current.end] + next.weight;
                        priorityQueue.add(next);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < dp.length; i++) {

            if (dp[i] == -1) {
                sb.append("INF");
            } else {
                sb.append(dp[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Node3 implements Comparable<Node3> {

    int end;
    int weight;

    public Node3(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node3 o) {
        return weight - o.weight;
    }
}
