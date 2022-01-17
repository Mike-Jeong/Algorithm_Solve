package programmers;

import java.util.*;

//3진법 뒤집기
//17012022

public class p17012022 {
    public static void main(String[] args) throws Exception {
        Solution19 s = new Solution19();

        int a = 45;

        System.out.println(s.solution(a));
        
    }
}

class Solution19 {

    public int solution(int n) {

        Stack<Integer> reverse = new Stack<>();

        while (n>=3) {
            reverse.add(n % 3);
            n /= 3;
        }
        reverse.add(n);

        int result = 0;
        int i = 0;

        while(!reverse.empty()){
            result += reverse.pop() * Math.pow(3, i);
            i++;
        }

        return result;
    }
}

/* public int solution(int n) {
        int ternary = 0;
        int m_10 = 1;

        while (n>=3) {
            ternary += (n % 3) * m_10;
            n /= 3;
            m_10 *= 10;
        }

        ternary += (n * m_10);

        System.out.println(ternary);
        System.out.println(m_10);

        int reverse_ternary = 0;

        while(ternary!=0){
            reverse_ternary = reverse_ternary * 10 + ternary % 10;
            ternary /= 10;
        }

        int result = 0;
        int i = 0;

        while(reverse_ternary!=0){
            result += (reverse_ternary % 10 * Math.pow(3, i));
            reverse_ternary /= 10;
            i++;
        }

        return result;
    }*/