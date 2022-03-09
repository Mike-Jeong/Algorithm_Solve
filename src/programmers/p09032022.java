package programmers;

import java.util.HashSet;
import java.util.Set;

//import java.util.*;

//영어 끝말잇기
//09032022

public class p09032022 {
    public static void main(String[] args) throws Exception {

        Solution70 s = new Solution70();

        int a = 2;
        String[] b = { "hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(s.solution(a, b));
    }
}

class Solution70 {

    public int[] solution(int n, String[] words) {
        int[] answer = { 0, 0 };

        String now = words[0];

        for (int i = 1; i < words.length; i++) {
            if (now.charAt(now.length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = answer[0]  / answer[0];
                break;
            }
            now = words[i];
        }

        return answer;
    }
}