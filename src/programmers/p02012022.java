package programmers;

import java.util.*;

//신규 아이디 추천
//02012022

public class p02012022 {
    public static void main(String[] args) throws Exception {
        Solution02 s = new Solution02();

        System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

class Solution02 {
    public String solution(String new_id) {
        String text = new_id;
        text = text.toLowerCase();
        text = text.replaceAll("[~!@#$%^&*()=+\\[\\{\\]\\}:?,<>/]", "");
        while (text.contains("..")) {
          text = text.replace("..", ".");
        }

        StringBuilder newString = new StringBuilder(text);

        if (newString.charAt(0) == '.') {

            newString.delete(0, 1);

        }

        if (newString.length() == 0) {

            newString.append("a");
        }

        if (newString.charAt(newString.length() - 1) == '.') {

            newString.delete(newString.length() - 1, newString.length());

        }

        if (newString.length() >= 16) {

            newString.setLength(15);

            if (newString.charAt(newString.length() - 1) == '.') {

                newString.delete(newString.length() - 1, newString.length());
            }

        }

        while(newString.length() <= 2) {
            
            if (newString.length() == 1) {

                newString.append(newString.charAt(0));
            }

            else{newString.append(newString.charAt(newString.length()-1));}
        }

        String answer = newString.toString();
        return answer;
    }
}