package programmers;

//import java.util.*;

//시저암호
//19022022

public class p19022022 {
    public static void main(String[] args) throws Exception {
        Solution52 s = new Solution52();

        String a = "AB";
        int b = 1;

        System.out.println(s.solution(a, b));
    }
}

class Solution52 {

    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i); 

            if (ch == ' ') {
                sb.append(ch);
                continue; 
            }
            
            if(Character.isLowerCase(ch)) { 
              
                ch = (char) ((ch - 'a' + n) % 26 + 'a'); 
            } 
            
            else {
                ch = (char) ((ch - 'A' + n) % 26 + 'A'); 
            }

            sb.append(ch);    
        }

        String answer = sb.toString();
        return answer;
    }
}