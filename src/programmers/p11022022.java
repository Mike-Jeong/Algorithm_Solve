package programmers;

//import java.util.*;

//문자열 다루기 기본
//11022022

public class p11022022 {
    public static void main(String[] args) throws Exception {
        Solution43 s = new Solution43();

        String a = "a234";

        System.out.println(s.solution(a));
    }
}

class Solution43 {

    public boolean solution(String s) {

        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}