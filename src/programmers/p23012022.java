package programmers;

import java.util.*;

//124 나라의 숫자
//23012022

public class p23012022 {
    public static void main(String[] args) throws Exception {
        Solution24 s = new Solution24();

        int a = 9;

        System.out.println(s.solution(a));

    }
}

class Solution24 {

    public String solution(int n) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int left = n % 3;
            n /= 3;
            
            if (left == 0) {
                left = 4;
                n -= 1;
            }

            sb.insert(0, left);
        }

        return sb.toString();
    }
}