package programmers;

//import java.util.*;

public class p04052022 {

    public static void main(String[] args) throws Exception {

        Solution107 s = new Solution107();

        String a = "I";

        System.out.println(s.solution(a));

    }
}

class Solution107 {

    String target;
    int count = 0;
    int answer;
    String[] words = { "A", "E", "I", "O", "U" };

    public int solution(String word) {

        target = word;
       
        recursion("", 0);
        return answer;
    }

    public void recursion(String word, int length) {

        if (length == 5 || target.equals(word)) {

            if (target.equals(word)) {
                answer = count;
            }

            return; 
        }

        for (int i = 0; i < 5; i++) {
            count++;
            String now = word + words[i];
            recursion(now, length + 1);
        }
    }
}