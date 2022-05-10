package programmers;

//import java.util.*;

//?
//05052022

public class p05052022 {

    public static void main(String[] args) throws Exception {

        Solution108 s = new Solution108();

        String[] words = {"hell", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"hell*", "goo*", "*able", "qua*"};

        System.out.println(s.solution(words,queries));

    }
}

class Solution108 {

    public int[] solution(String[] words, String[] queries) {

        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            int star = queries[i].indexOf("*");
            String word = queries[i].replace("*", "");

            for (String tar : words) {
                if (star != 0) {
                    if (tar.startsWith(word)) {
                        count++;
                    }
                } else {
                    if (tar.endsWith(word)) {
                        count++;
                    }
                }
            }

            answer[i] = count;
        }
        return answer;
    }
}