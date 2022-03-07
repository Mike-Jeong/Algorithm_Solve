package programmers;

import java.util.*;

//다리를 지나는 트럭
//07032022

public class p07032022 {
    public static void main(String[] args) throws Exception {

        Solution68 s = new Solution68();

        // int a = 5;
        // int[][] b = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1
        // }, { 5, 4, 2 } };
        // int c = 3;

        int a = 6;
        int[][] b = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
        int c = 4;

        s.solution(a, b, c);
        System.out.println();
    }
}

class Solution68 {

    int count = 0;
    int limit;
    boolean[] visited;
    int[][] weight;
    Map<Integer, Queue<Integer>> map = new HashMap<>();
    Set<Integer> able = new HashSet<>();

    public int solution(int N, int[][] road, int K) {

        visited = new boolean[N];
        weight = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(weight[i], 10000);
        }
        limit = K;

        for (int i = 1; i <= N; i++) {
            visited[i - 1] = false;
            Queue<Integer> near_town = new LinkedList<>();
            map.put(i, near_town);
        }

        for (int[] is : road) {

            weight[is[0] - 1][is[1] - 1] = Math.min(weight[is[0] - 1][is[1] - 1], is[2]);
            weight[is[1] - 1][is[0] - 1] = Math.min(weight[is[1] - 1][is[0] - 1], is[2]);

            if (!map.get(is[0]).contains(is[1])) {
                map.get(is[0]).add(is[1]);
            }

            if (!map.get(is[1]).contains(is[0])) {
                map.get(is[1]).add(is[0]);
            }
        
        }

        dfs(1, 0);
        return able.size();
    }

    public void dfs(int current_town, int dis) {
            
        able.add(current_town);
        visited[current_town - 1] = true;
        
        Queue<Integer> near_list = map.get(current_town);

        for (int i = 0; i < near_list.size(); i++) {
            int next_town = near_list.poll();
            if (!visited[next_town - 1]) {
                
                if (dis + weight[current_town - 1][next_town - 1] <= limit) {
                    dfs(next_town, dis + weight[current_town - 1][next_town - 1]);
                    visited[next_town - 1] = false;
                }
            }
            near_list.add(next_town);
        }
    }
}