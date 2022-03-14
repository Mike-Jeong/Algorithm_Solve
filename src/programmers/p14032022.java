package programmers;

import java.util.*;

//게임 맵 최단거리
//14032022

public class p14032022 {
    public static void main(String[] args) throws Exception {

        Solution78 s = new Solution78();

        int[][] a = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } };

        System.out.println(s.solution(a));

    }
}

class Solution78 {

    public int solution(int[][] maps) {
        int answer = 0;
        return answer;
    }
}