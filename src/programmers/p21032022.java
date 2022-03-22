package programmers;

//import java.util.*;

//다음 큰 숫자
//21032022

public class p21032022 {

    public static void main(String[] args) throws Exception {

        Solution86 s = new Solution86();

        int a = 3;

        System.out.println(s.solution(a));

    }
}

class Solution86 {

    public int solution(int n) {


        String target = Integer.toBinaryString(n);

        int one_count = 0;
        int answer = 0;

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                one_count++;
            }
        }

        for (int i = n + 1; i < 2 * n; i++) {
            String check = Integer.toBinaryString(i);

            int ck_one_count = 0;

            for (int j = 0; j < check.length(); j++) {
                if (check.charAt(j) == '1') {
                    ck_one_count++;
                }
            }

            if (one_count == ck_one_count) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}