package programmers;

import java.util.*;

//?
//08022022

public class p08022022 {
    public static void main(String[] args) throws Exception {
        Solution40 s = new Solution40();

        String a = "1 2 3 4";

        System.out.println(s.solution(a));
    }
}

class Solution40 {

    public String solution(String s) {

        String[] array = s.split(" ");
        int[] ans = new int[array.length];

        int i = 0;
        for (String str : array) {
            ans[i] = Integer.parseInt(str);
            i++;
        }

        Arrays.sort(ans);

        String answer = String.valueOf(ans[0]) + " " + String.valueOf(ans[ans.length-1]);
        return answer;
    }
}