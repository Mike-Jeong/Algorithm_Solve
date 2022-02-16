package programmers;

import java.util.*;

//수박수박수박수박수박수?
//16022022

public class p16022022 {
    public static void main(String[] args) throws Exception {
        Solution49 s = new Solution49();

        int a = 3;
        //4

        System.out.println(s.solution(a));
    }
}

class Solution49 {

    public String solution(int n) {
        StringBuilder ans = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            if (i == 0 || i % 2 == 0) {
                ans.append("수");
            }
            else{ans.append("박");}
        }

        String answer = ans.toString();
        return answer;
    }
}

//5분컷