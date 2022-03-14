package programmers;

import java.util.*;

//네트워크
//15032022

public class p15032022 {

    public static void main(String[] args) throws Exception {

        Solution79 s = new Solution79();

        int a = 3;
        int[][] b = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

        System.out.println(s.solution(a, b));

    }
}

class Solution79 {

    boolean[] visited;
    Map<Integer, LinkedList<Integer>> near_nodes = new HashMap<>();

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    if (near_nodes.containsKey(i)) {
                        near_nodes.get(i).add(j);
                    } else {
                        LinkedList<Integer> near_n = new LinkedList<>();
                        near_n.add(j);
                        near_nodes.put(i, near_n);
                    }
                    if (near_nodes.containsKey(j)) {
                        near_nodes.get(j).add(i);
                    } else {
                        LinkedList<Integer> near_n = new LinkedList<>();
                        near_n.add(i);
                        near_nodes.put(j, near_n);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                recursion(i);

                answer++;
            }
        }

        return answer;
    }

    public void recursion(int i){
        
        LinkedList<Integer> next_nodes = near_nodes.get(i);
        visited[i] = true;

        if (next_nodes != null) {
            int size = next_nodes.size();
            for (int j = 0; j < size; j++) {
                int next = next_nodes.poll();
                if (!visited[next]) {
                    recursion(next);
                }
                
            }
        }
       
    }
}