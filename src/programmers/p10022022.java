package programmers;

import java.util.*;

//문자열 내림차순으로 배치하기
//10022022

public class p10022022 {
    public static void main(String[] args) throws Exception {
        Solution42 s = new Solution42();

        String a = "Zbcdefg";

        System.out.println(s.solution(a));
    }
}

class Solution42 {

    public String solution(String s) {

        char[] string = s.toCharArray();
        Arrays.sort(string);
        String answer = new StringBuilder(new String(string)).reverse().toString();
        return answer;
    }
}