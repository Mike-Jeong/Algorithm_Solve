package programmers;

import java.util.*;

//?
//26052022

public class p26052022 {

    public static void main(String[] args) throws Exception {

        Solution111 s = new Solution111();

        int[][] a = { { 0, 0, 0, 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 } };
        int[] b = { 5, 4, 3, 1 };
        int[] c = { 4, 6, 2, 8 };

        System.out.println(s.solution("5015153045"));

    }
}

class Solution111 {

    String s;

    public int[] solution(String nums) {

        List<Integer> res = new ArrayList<>();

        int[] answer = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    

}
