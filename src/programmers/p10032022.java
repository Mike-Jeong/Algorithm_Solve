package programmers;

import java.util.*;

//예상 대진표
//10032022

public class p10032022 {
    public static void main(String[] args) throws Exception {

        Solution71 s = new Solution71();

        int a = 8;
        int b = 1;
        int c = 2;

        System.out.println(s.solution(a, b, c));
    }
}

class Solution71 {

    public int solution(int n, int a, int b) {

        int round = 1;
        int group_a = (int) Math.ceil((double) a / 2);
        int group_b = (int) Math.ceil((double) b / 2);

        while (group_a != group_b) {

            group_a = (int) Math.ceil((double) group_a / 2);
            group_b = (int) Math.ceil((double) group_b / 2);
            round++;
        }

        return round;
    }
}