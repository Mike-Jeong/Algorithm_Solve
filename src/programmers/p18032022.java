package programmers;

import java.util.*;

//가장 먼 노드
//18032022

public class p18032022 {

    public static void main(String[] args) throws Exception {

        Solution83 s = new Solution83();

        int a = 6;
        int[][] b = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

        System.out.println(s.solution(a, b));

    }
}

class Solution83 {

    boolean[] visited;
    int[] count;
    int max = 0;
    int max_c = 1;
    Map<Integer, LinkedList<Integer>> near_n = new HashMap<>();
    Queue<Integer> order = new LinkedList<>();

    public int solution(int n, int[][] edge) {

        visited = new boolean[n + 1];
        count = new int[n+1];

        for (int[] is : edge) {
            if (near_n.containsKey(is[0])) {
                near_n.get(is[0]).add(is[1]);
            } else {
                LinkedList<Integer> near = new LinkedList<>();
                near.add(is[1]);
                near_n.put(is[0], near);
            }
            if (near_n.containsKey(is[1])) {
                near_n.get(is[1]).add(is[0]);
            } else {
                LinkedList<Integer> near = new LinkedList<>();
                near.add(is[0]);
                near_n.put(is[1], near);
            }
        }

        order.add(1);
        
        while (!order.isEmpty()) {

            Integer now = order.poll();
            visited[now] = true;
            DFS(now);
            if (count[now] >= max) {
                if (count[now] == max) {
                    max_c++;
                } else {
                    max = count[now];
                    max_c = 1;
                }
            }
        }

        int answer = max_c;
        return answer;
    }

    public void DFS(int node) {
        
        LinkedList<Integer> neighbour_n = near_n.get(node);

        for (Integer integer : neighbour_n) {
            if (!order.contains(integer) && !visited[integer]) {
                order.add(integer);
                count[integer] = count[node] + 1;
            }
        }

    }
}