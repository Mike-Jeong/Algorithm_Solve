package programmers;

import java.util.*;

//짝지어 제거하기
//13022022

public class p13022022 {
    public static void main(String[] args) throws Exception {
        Solution45 s = new Solution45();

        String a = "baabaa";

        System.out.println(s.solution(a));
    }
}

class Solution45 {

    public int solution(String s)
    {
        return recursion(s);
    }

    public int recursion(String s){

        if (s.length() == 0) {
            return 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                s = s.replaceAll(s.substring(i, i+2), "");
                return recursion(s);
            }
        }

        return 0;
    }
}