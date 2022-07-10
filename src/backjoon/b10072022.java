package backjoon;

import java.io.*;
import java.util.*;

//특정 거리의 도시 찾기
//10072022

public class b10072022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Town>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<Town>());
            }

            map.get(s).add(new Town(e, 1));
        }

        PriorityQueue<Town> priorityQueue = new PriorityQueue<>();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 987654321);
        priorityQueue.add(new Town(x, 0));
        dp[x] = 0;

        while (!priorityQueue.isEmpty()) {

            Town current = priorityQueue.poll();

            if (map.containsKey(current.end)) {
                ArrayList<Town> list = map.get(current.end);

                for (int i = 0; i < list.size(); i++) {
                    Town next = list.get(i);

                    if (dp[next.end] > dp[current.end] + next.weight) {
                        dp[next.end] = dp[current.end] + next.weight;
                        priorityQueue.add(new Town(next.end, dp[next.end]));
                    }
                }
            }
            
        }  
        
        int count = 0;
        for (int i = 1; i < dp.length; i++) {

            if (dp[i] == k && i != x) {
                count++;
                System.out.println(i);
            }
        }

        if (count == 0) {
            System.out.println(-1);
        }
    }
}

class Town implements Comparable<Town> {

    int end;
    int weight;

    public Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Town o) {
        return weight - o.weight;
    }
}

