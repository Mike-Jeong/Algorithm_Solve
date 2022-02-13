package programmers;

import java.util.*;

//짝지어 제거하기
//13022022

public class p13022022 {
    public static void main(String[] args) throws Exception {
        Solution45 s = new Solution45();

        String a = "baabaa";

        System.out.println(s.solution(a));
    }
}

class Solution45 {

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }

            stack.add(s.charAt(i));

        }

        return stack.empty() ? 1 : 0;


    }
}

/* 
 public int solution(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return recursion(sb);
    }

    public int recursion(StringBuilder sb){

        if (sb.length() == 0) {
            return 1;
        }

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i+1)) {
                sb.replace(i, i + 2, "");
                return recursion(sb);
            }
        }

        return 0;
    }
*/

//재귀함수로 시도
//But 효율성 bad ㅠㅠ