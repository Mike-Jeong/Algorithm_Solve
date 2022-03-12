package programmers;

import java.util.*;

//전력망을 둘로 나누기
//12032022

public class p12032022 {
    public static void main(String[] args) throws Exception {

        Solution75 s = new Solution75();

        int a = 9;
        int[][] b = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
       // int[][] c = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        //int[][] d = { { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } };
       // int[][] e = { { 1, 2 }, { 2, 3 } };
       // int[][] f = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 5, 7 }, { 7, 8 }, { 8, 9 } };

       System.out.println(s.solution(a, b));
       // System.out.println("&&&&&&&&&");
       // System.out.println(s.solution(4, c));
       // System.out.println("&&&&&&&&&");
       // System.out.println(s.solution(7, d));
       // System.out.println("&&&&&&&&&");
        //System.out.println(s.solution(3, e));
       // System.out.println("&&&&&&&&&");
       // System.out.println(s.solution(a, f));
    }
}

class Solution75 {

    Map<Integer, ArrayList<Integer>> nodes = new LinkedHashMap<>();
    int count;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        for (int[] is : wires) {
            if (!nodes.containsKey(is[0])) {
                ArrayList<Integer> n_nodes = new ArrayList<>();
                nodes.put(is[0], n_nodes);
                nodes.get(is[0]).add(is[1]);
            } else {
                nodes.get(is[0]).add(is[1]);
            }

            if (!nodes.containsKey(is[1])) {
                ArrayList<Integer> n_nodes = new ArrayList<>();
                nodes.put(is[1], n_nodes);
                nodes.get(is[1]).add(is[0]);
            } else {
                nodes.get(is[1]).add(is[0]);
            }
        }

        for (int[] is : wires) {
          nodes.get(is[0]).remove((Integer)is[1]);
          nodes.get(is[1]).remove((Integer)is[0]);

          boolean[] visited = new boolean[n];

          count = 0;
          recursion(is[0], visited);
          int a = count;

          count = 0;
          recursion(is[1], visited);
          int b = count;

          answer = Math.min(Math.abs(a - b), answer);

          nodes.get(is[0]).add(is[1]);
          nodes.get(is[1]).add(is[0]);
        }

        return answer;
    }

    public void recursion(int a, boolean[] visited) {

        visited[a - 1] = true;
        count ++;

        for (int b : nodes.get(a)) {
            if (!visited[b - 1]) {
                recursion(b, visited);
            }
            
        }

    
    }
}


/*
 public int solution(int n, int[][] wires) {

        Map<Integer, List<Integer>> nodes = new LinkedHashMap<>();
        Set<Integer> p_nodes = new LinkedHashSet<>();
        List<Integer> n_purenode = new ArrayList<>();

        int answer = Integer.MAX_VALUE;
        int current_n = 0;

        for (int[] is : wires) {
            if (!nodes.containsKey(is[0])) {
                List<Integer> n_nodes = new LinkedList<>();
                nodes.put(is[0], n_nodes);
                nodes.get(is[0]).add(is[1]);
            } else {
                nodes.get(is[0]).add(is[1]);
            }

            if (!nodes.containsKey(is[1])) {
                List<Integer> n_nodes = new LinkedList<>();
                nodes.put(is[1], n_nodes);
                nodes.get(is[1]).add(is[0]);
            } else {
                nodes.get(is[1]).add(is[0]);
            }
        }

        for (int is : nodes.keySet()) {
            if (nodes.get(is).size() != 1) {

                int count = 0;
                for (int n_node : nodes.get(is)) {
                    if (nodes.get(n_node).size() == 1) {
                        count++;
                    }
                }
                n_purenode.add(count + 1);
            }
        }

        answer = Math.min(((n - 1) - 1), answer);

        for (int i = 0; i < n_purenode.size(); i++) {

            current_n += n_purenode.get(i);

            int ma = Math.max(n - current_n, current_n);
            int mi = Math.min(n - current_n, current_n);

            answer = Math.min((ma - mi), answer);
        }

        return answer;
    }
*/