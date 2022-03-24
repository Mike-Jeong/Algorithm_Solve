package programmers;

import java.util.*;

//가장 큰 정사각형 찾기
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
        String ans = "";

        String[] srr = s.toLowerCase().split("");
        
        boolean isFirst = true;
        
        for(int i = 0; i < srr.length; i++) {
            
            ans += isFirst ? srr[i].toUpperCase() : srr[i];
            isFirst = srr[i].equals(" ") ? true : false;            
        }
        
        return ans;
    }
}