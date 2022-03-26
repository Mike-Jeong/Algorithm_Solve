package programmers;

//import java.util.*;

//JadenCase 문자열 만들기
//25032022

public class p25032022 {

    public static void main(String[] args) throws Exception {

        Solution90 s = new Solution90();

        String a = "3people unFollowed me";
        System.out.println(s.solution(a));

    }
}

class Solution90 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] srr = s.toLowerCase().split("");
        
        boolean isFirst = true;
        
        for(int i = 0; i < srr.length; i++) {

            sb.append(isFirst ? srr[i].toUpperCase() : srr[i]);
            isFirst = srr[i].equals(" ") ? true : false;            
        }
        
        return sb.toString();
    }
}
//효율성에서 계속 오류나서 인터넷 퍼옴
// 아직 이해 못함 (25.03.2022 am 06 : 39)
// 이해 완(26.03.2022 am 10 : 23)