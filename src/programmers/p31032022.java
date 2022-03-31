package programmers;

//import java.util.*;

//자릿수 더하기
//31032022

public class p31032022 {

    public static void main(String[] args) throws Exception {

        Solution95 s = new Solution95();

        int a = 2;

        System.out.println(s.solution(a));

    }
}

class Solution95 {

    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += (n % 10);
            n /= 10;
        }
        
        return answer;
    }
}