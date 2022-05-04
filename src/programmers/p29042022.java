package programmers;

import java.util.*;

//?
//29042022

public class p29042022 {

    public static void main(String[] args) throws Exception {

        Solution106 s = new Solution106();

        int a = 3;

        int[][] b = {{1, 3}, {2, 3}};

        System.out.println(s.solution(a, b));

    }
}

class Solution106 {

    public int solution(int N, int[][] trust) {

        Map<Integer, Set<Integer>> ck = new HashMap<>();
        Set<Integer> tr = new HashSet<>();

        for (int[] is : trust) {
            if (!ck.containsKey(is[1])) {
                Set<Integer> set = new HashSet<>();
                ck.put(is[1], set);
            }

            tr.add(is[0]);
            ck.get(is[1]).add(is[0]);
        }

        int answer = -1;

        for (int i = 1; i <= N; i++) {
            if (ck.containsKey(i)) {
                if (ck.get(i).size() == (N - 1) && !tr.contains(i)) {
                    return i;
                }
            }

        }

        return answer;
    }
}
