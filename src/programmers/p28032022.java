package programmers;

import java.util.*;

//정수 내림차순으로 배치하기
//28032022

public class p28032022 {

    public static void main(String[] args) throws Exception {

        Solution92 s = new Solution92();

        long a = 437674;

        System.out.println(s.solution(a));

    }
}

class Solution92 {

    public long solution(long n) {

        ArrayList<Long> num = new ArrayList<>();

        while (n != 0) {

            long a = n % 10;
            num.add(a);
            n /= 10;
            
        }

        Collections.sort(num, Collections.reverseOrder());

        long answer = 0;

        for (int i = 0; i < num.size(); i++) {

            answer = (answer * 10) + num.get(i);
        }
        return answer;
    }
}