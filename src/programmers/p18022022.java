package programmers;

//import java.util.*;

//문자열을 정수로 바꾸기
//18022022

public class p18022022 {
    public static void main(String[] args) throws Exception {
        Solution51 s = new Solution51();

        String a = "1234";

        System.out.println(s.solution(a));
    }
}

class Solution51 {

    public int solution(String s) {
        int answer = Integer.parseInt(s);
        return answer;
    }
}