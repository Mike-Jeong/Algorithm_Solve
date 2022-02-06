package programmers;

import java.util.*;

//문자열 내 마음대로 정렬하기
//06022022

public class p06022022 {
    public static void main(String[] args) throws Exception {
        Solution38 s = new Solution38();

        String[] a = {"sun", "bed", "car"};
        int b = 1;

        System.out.println(s.solution(a, b));
    }
}

class Solution38 {

    public String[] solution(String[] strings, int n) {
        Map<Character, TreeSet<String>> treemap = new HashMap<>();

        for (String string : strings) {

            if (treemap.containsKey(string.charAt(n))) {

                treemap.get(string.charAt(n)).add(string);
            
            } else {
                TreeSet<String> values = new TreeSet<>();
                values.add(string);
                treemap.put(string.charAt(n), values);
            }
        }

        List<Character> keys = new LinkedList<>();
        List<String> ans = new LinkedList<>();

        for (char c : treemap.keySet()) {
            keys.add(c);
        }

        Collections.sort(keys);

        for (Character character : keys) {

            for (String string : treemap.get(character)) {
                ans.add(string);   
            }
        }

        int i = 0;
        String[] answer = new String[ans.size()];

        for (String string : ans) {
            answer[i] = string;
            i++;
        }

        return answer;
    }
}