package programmers;

import java.util.*;

//거리두기 확인하기
//11032022

public class p11032022 {
    public static void main(String[] args) throws Exception {

        Solution73 s = new Solution73();

        String[][] a = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(s.solution(a));
    }
}

class Solution73 {

    public int[] solution(String[][] places) {
        int[] answer = {};
        return answer;
    }
}