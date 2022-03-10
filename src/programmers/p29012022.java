package programmers;

//import java.util.*;

//가운데 글자 가져오기
//29012022

public class p29012022 {
    public static void main(String[] args) throws Exception {
        Solution30 s = new Solution30();
        String a = "qwer";
        System.out.println(s.solution(a));

    }
}

class Solution30 {

    public String solution(String s) {
        int size = s.length();
        String answer = "";
        if (size % 2 == 0) {
            answer = s.substring(size/2 -1, size/2 + 1);
        }
        else{
            answer = String.valueOf(s.charAt(size/2));
        }
        return answer;
    }
}