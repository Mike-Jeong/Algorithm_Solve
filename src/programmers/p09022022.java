package programmers;

//import java.util.*;

//문자열 내 p와 y의 개수
//09022022

public class p09022022 {
    public static void main(String[] args) throws Exception {
        Solution41 s = new Solution41();

        String a = "oooo";

        System.out.println(s.solution(a));
    }
}

class Solution41 {

    boolean solution(String s) {

        int check = 0;

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                check += 1;
            }

            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                check -= 1;
            }
        }

        return check == 0 ? true : false;
    }
}