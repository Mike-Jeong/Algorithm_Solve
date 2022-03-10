package programmers;

//import java.util.*;

//약수의 합
//20022022

public class p20022022 {
    public static void main(String[] args) throws Exception {
        Solution53 s = new Solution53();

        int a = 12;

        System.out.println(s.solution(a));
    }
}

class Solution53 {

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer  += i;
            }
        }
        return answer;
    }
}