package programmers;

//import java.util.*;

//핸드폰 번호 가리기
//06042022

public class p06042022 {

    public static void main(String[] args) throws Exception {

        Solution99 s = new Solution99();

        String a = "01033334444";

        System.out.println(s.solution(a));

    }
}

class Solution99 {

    public String solution(String phone_number) {

        char[] charArray = phone_number.toCharArray();
        for (int i = 0; i < charArray.length - 4; i++) {
            charArray[i] = '*';
        }
        
        String newString = String.valueOf(charArray);
        return newString;
    }
}