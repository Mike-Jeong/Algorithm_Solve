package programmers;

import java.util.*;

//숫자의 표현
//03032022

public class p03032022 {
    public static void main(String[] args) throws Exception {

        Solution64 s = new Solution64();

        int a = 15;

        System.out.println(s.solution(a));
    }
}

class Solution64 {

    int count = 0;
    int target;

    public int solution(int n) {

        target = n;

        for (int i = 0; i < n; i++) {
            recursion(i + 1);
        }

        return count;
    }

    public void recursion(int n) {

        int sum = 0;

        while (sum < target) {
            
            sum += n;
            n++;
        }

        if (sum == target) {
            count++;
        }

    }
}