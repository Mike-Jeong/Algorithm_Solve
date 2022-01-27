package programmers;

import java.util.*;

//부족한 금액 계산하기
//27012022

public class p27012022 {
    public static void main(String[] args) throws Exception {
        Solution28 s = new Solution28();

        int a = 3;
        int b = 20;
        int c = 4;//10

        System.out.println(s.solution(a,b,c));

    }
}

class Solution28 {

    public long solution(int price, int money, int count) {

        long totalprice = 0;
        int usecount = 1;

        while (usecount <= count)
        {
            totalprice += (price * usecount);
            usecount++;
        }

        long answer = totalprice - money;
        if (answer <= 0) {
            answer = 0;
        }

        return answer;
    }
}