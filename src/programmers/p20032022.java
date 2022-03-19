package programmers;

import java.util.*;

//순위
//20032022

public class p20032022 {

    public static void main(String[] args) throws Exception {

        Solution85 s = new Solution85();

        int a = 5;
        int[][] b = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

        System.out.println(s.solution(a, b));

    }
}

class Solution85 {

    Map<Integer, ArrayList<Integer>> win_rec = new HashMap<>();
    Map<Integer, ArrayList<Integer>> lose_rec = new HashMap<>();

    public int solution(int n, int[][] results) {

        int answer = 0;

        for (int[] is : results) {

            if (win_rec.containsKey(is[0])) {
                win_rec.get(is[0]).add(is[1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(is[1]);
                win_rec.put(is[0], list);
            }

            if (lose_rec.containsKey(is[1])) {
                lose_rec.get(is[1]).add(is[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(is[0]);
                lose_rec.put(is[1], list);
            }
        }

        for (int i = 1; i <= n; i++) {

            boolean[] visited = new boolean[n];

            if (win_rec.get(i) != null) {
                recursion(i, visited, 'w');
            }

            if (lose_rec.get(i) != null) {
                recursion(i, visited, 'l');
            }

            Boolean bool = true;

            for (int j = 0; j < visited.length; j++) {
                if (!visited[j]) {
                    bool = false;
                    break;
                }
            }

            if (bool) {
                answer++;
            }
        
        }

        
        return answer;
    }

    public void recursion(Integer n, boolean[] visited, char c) {

        visited[n - 1] = true;

        if (c == 'w') {
            if (win_rec.get(n) != null) {
                for (Integer i : win_rec.get(n)) {
                    if (!visited[i - 1]) {
                        recursion(i, visited, c);
                    }
                }
            }

        } else {
            if (lose_rec.get(n) != null) {
                for (Integer i : lose_rec.get(n)) {
                    if (!visited[i - 1]) {
                        recursion(i, visited, c);
                    }
                }
            }
        }
    }
}