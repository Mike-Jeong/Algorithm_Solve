package programmers;

import java.util.*;

//숫자 문자열과 영단어
//03012022

public class p03012022 {
    public static void main(String[] args) throws Exception {
        Solution03 s = new Solution03();

        System.out.println(s.solution("one4seveneight"));
    }
}

class Solution03 {
    public int solution(String s) {

        Map<String, Integer> w_to_num = new HashMap<String, Integer>();

        w_to_num.put("zero", 0);
        w_to_num.put("one", 1);
        w_to_num.put("two", 2);
        w_to_num.put("three", 3);
        w_to_num.put("four", 4);
        w_to_num.put("five", 5);
        w_to_num.put("six", 6);
        w_to_num.put("seven", 7);
        w_to_num.put("eight", 8);
        w_to_num.put("nine", 9);


        String text = s;

        for (String key : w_to_num.keySet()) {
            
            text = text.replace(key, w_to_num.get(key).toString());
        }

       
        int answer = Integer.parseInt(text);
        return answer;

    }
}