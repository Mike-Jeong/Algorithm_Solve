package programmers;

import java.util.*;

//모의고사
//11012022

public class p11012022 {
    public static void main(String[] args) throws Exception {
        Solution13 s = new Solution13();

        int[] a = { 1, 2, 3, 4, 5 };

        System.out.println(s.solution(a));
    }
}

class Solution13 {

    public int[] solution(int[] answers) {

        int[] s_1 = { 1, 2, 3, 4, 5 };
        int[] s_2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] s_3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        Integer[] score = { 0, 0, 0 };

        int i = 0;
        for (int ans : answers) {

            if (ans == s_1[i % 5]) {
                score[0]++;
            }

            if (ans == s_2[i % 8]) {
                score[1]++;
            }

            if (ans == s_3[i % 10]) {
                score[2]++;
            }
            i++;
        }

        int[] answer;

        ArrayList<Integer> result = new ArrayList<Integer>();

        int max = Math.max(score[0], Math.max(score[1], score[2]));

        int index = 0;

        for (Integer integer : score) {

            if (integer == max) {

                result.add(index);
                
            }

            index++;      
        }

        answer = new int[result.size()];

        for (int j = 0; j < answer.length; j++) {
            
            answer[j] = result.get(j) + 1;
        }
        Arrays.sort(answer);
        return answer;
    }
}