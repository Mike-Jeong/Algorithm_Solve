package programmers;

//import java.util.*;

//피보나치 수
//11042022

public class p11042022 {

    public static void main(String[] args) throws Exception {

        Solution102 s = new Solution102();

        int a = 4;

        System.out.println(s.solution(a));

    }
}

class Solution102 {

    int[] fibo = new int[100001];

    public int solution(int n) {

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            find_fibo(i);
        }

        int answer = fibo[n];
        return answer;
    }

    public void find_fibo(int n) {

        fibo[n] = ((fibo[n - 1] + fibo[n - 2]) % 1234567);

    }
}