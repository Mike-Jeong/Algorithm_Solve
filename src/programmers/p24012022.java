package programmers;

import java.util.*;

//2016년
//24012022

public class p24012022 {
    public static void main(String[] args) throws Exception {
        Solution25 s = new Solution25();

        int a = 7;
        int b = 7;

        System.out.println(s.solution(a, b));

    }
}

class Solution25 {

    public String solution(int a, int b) {
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate += date[i];
        }

        allDate += (b - 1);
        answer = day[allDate % 7];

        return answer;
    }

}