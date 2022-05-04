package programmers;

//import java.util.*;

//디코딩
//21042022

public class p21042022 {

    public static void main(String[] args) throws Exception {

        Solution104 s = new Solution104();

        String a = "5{he2{l}o}friend";

        System.out.println(s.solution(a));

    }
}

class Solution104 {

    public String solution(String code) {

        while (true) {
            if (code.contains("}")) {

                int i = code.indexOf("}");
                String s = code.substring(0, i);
                String s2 = code.substring(0, i + 1);

                code = code.replace(s2, recursion(s));

            } else {
                break;
            }
        }

        return code;
    }

    public String recursion(String s) {

        String words = s;

        int idx = words.lastIndexOf("{");

        String ch = words.substring(idx + 1);

        int num = Character.getNumericValue(words.charAt(idx - 1));

        String wrd = words.substring(0, idx - 1);

        for (int i = 0; i < num; i++) {
            wrd += ch;
        }

        return wrd;
    }
}