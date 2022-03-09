package programmers;

import java.util.*;

//영어 끝말잇기
//09032022

public class p09032022 {
    public static void main(String[] args) throws Exception {

        Solution70 s = new Solution70();

        int a = 3;
        String[] b = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(s.solution(a, b));
    }
}

class Solution70 {

    public int[] solution(int n, String[] words) {

        Set<String> word_s = new HashSet<>();
        int[] answer = {0,0};

        word_s.add(words[0]);
        for (int i = 1; i < words.length; i++) {

            if (word_s.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length()-1)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            word_s.add(words[i]);
        }

        return answer;
    }
}