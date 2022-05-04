package programmers;

//import java.util.*;

//모음 사전
//04052022

public class p04052022 {

    public static void main(String[] args) throws Exception {

        Solution107 s = new Solution107();

        String a = "AU";

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

            return; 
        }

        for (int i = 0; i < 5; i++) {
            count++;
            String now = word + words[i];

            if (target.equals(now)) {
                answer = count;
                return;
            }

            recursion(now, length + 1);
        }
    }
}


/*

 public boolean recursion(String word, int length) {

        if (length == 5) {

            return false; 
        }

        for (int i = 0; i < 5; i++) {
            count++;
            String now = word + words[i];
            System.out.println(now);

            if (target.equals(now)) {
                answer = count;
                return true;
            }

            if (recursion(now, length + 1)) {
                return true;
            }
            
        }

        return false;
    }

*/