package programmers;

import java.util.*;

//전력망을 둘로 나누기
//12032022

public class p12032022 {
    public static void main(String[] args) throws Exception {

        Solution75 s = new Solution75();

        int a = 9;
        int[][] b = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };

        System.out.println(s.solution(a, b));
    }
}

class Solution75 {

    Map<Integer, List<Integer>> near_nodes = new HashMap<>();

    public int solution(int n, int[][] wires) {
        int answer = -1;

        for (int[] is : wires) {
            if (!near_nodes.containsKey(is[0])) {
                List<Integer> n_nodes = new LinkedList<>();
                near_nodes.put(is[0], n_nodes);
                near_nodes.get(is[0]).add(is[1]);
            } else {
                near_nodes.get(is[0]).add(is[1]);
            }

            if (!near_nodes.containsKey(is[1])) {
                List<Integer> n_nodes = new LinkedList<>();
                near_nodes.put(is[1], n_nodes);
                near_nodes.get(is[1]).add(is[0]);
            } else {
                near_nodes.get(is[1]).add(is[0]);
            }
        }

        for (int is : near_nodes.keySet()) {
            if (near_nodes.get(is).size() != 1) {

            }
        }
        return answer;
    }

    public void recursion() {

    }
}