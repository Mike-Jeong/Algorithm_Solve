package programmers;

import java.util.*;
import java.util.stream.Collectors;

//신고 결과 받기
//15012022

public class p15012022 {
    public static void main(String[] args) throws Exception {
        Solution17 s = new Solution17();

        String[] a = {"muzi", "frodo", "apeach", "neo"};
        String[] b = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int c = 2;
        System.out.println(s.solution(a, b,c));
    }
}

class Solution17 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        return answer;
    }
}