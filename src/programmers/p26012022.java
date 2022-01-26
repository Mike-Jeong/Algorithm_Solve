package programmers;

import java.util.*;

//나머지가 1이 되는 수 찾기
//26012022

public class p26012022 {
    public static void main(String[] args) throws Exception {
        Solution27 s = new Solution27();

        int a = 10;


        System.out.println(s.solution(a));

    }
}

class Solution27 {

    public int solution(int n) {
        
        int a = 1;
        while (a<n) {
            if (n%a == 1) {
                break;
            }
            a++;
        }
        int answer = a;
        return answer;
    }
}