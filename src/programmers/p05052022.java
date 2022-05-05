package programmers;

import java.util.*;

//?
//05052022

public class p05052022 {

    public static void main(String[] args) throws Exception {

        Solution108 s = new Solution108();

        int[][] a = {{1, 8, 4}, {2, 4, 10}, {3, 5, 6}, {10, 12, 6}};
        int[] b = {2, 4, 2, 1, 3};

        System.out.println(s.solution(a));

    }
}

class Solution108 {

    public String[][] solution(String[] words, String[] queries) {

        String[][] answer = new String[queries.length][];

        int index = 0;
        for (String string : queries) {

            String word = string.replace("?", "");
            int len =  string.length();

            ArrayList<String> ans = new ArrayList<>();

            for (String str : words) {
                if (len == 1 && str.length() == 1) {
                    ans.add(str);
                }

                else {
                    if (str.contains(word) && str.length() == len) {
                        ans.add(str);
                    }
                }
            }

            answer[index] = new String[ans.size()];

            for (int i = 0; i < ans.size(); i++) {
                answer[index][i] = ans.get(i);
            }

            index++;
        }
        
        return answer;
    }
}