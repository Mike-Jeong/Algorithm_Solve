package programmers;

import java.util.*;

//완주하지 못한 선수
//09012022

public class p09012022 {
    public static void main(String[] args) throws Exception {
        Solution11 s = new Solution11();

        String[] a = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(s.solution(a, b));
    }
}

class Solution11 {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> plist = new HashMap<String, Integer>();
        String answer = "";

        for (String string : participant) {
            if (!plist.containsKey(string)) {
                plist.put(string, 1);
            } else {
                plist.replace(string, plist.get(string), plist.get(string)+1);
            }       
        }

        for (String string : completion) {

            plist.replace(string, plist.get(string), plist.get(string)-1);
        }

        for (String string : plist.keySet()) {
            if (plist.get(string) != 0) {
                answer = string;
            }
            
        }

        return answer;

    }
}