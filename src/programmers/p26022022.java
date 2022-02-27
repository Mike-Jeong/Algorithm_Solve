package programmers;

import java.util.*;

//큰 수 만들기
//26022022

public class p26022022 {
    public static void main(String[] args) throws Exception {

        Solution59 s = new Solution59();

        String a = "4177252841";
        int b = 4;

        System.out.println(s.solution(a,b));
    }
}

class Solution59 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString(); // 인터넷 퍼옴
    }
}

/*
public String solution(String number, int k) {

        int count = 0;
        int i = 0;

        while (count < k) {
           
            int current = Character.getNumericValue(number.charAt(i));
            int next = Character.getNumericValue(number.charAt(i+1));

            if (current < next) {
                number = number.replaceFirst(String.valueOf(current), "");
                i = 0;
                count ++;
            }
            else{
                i++;
            }
        }
        return number;
    }
 */
// 시간초과, 런타임 에러......