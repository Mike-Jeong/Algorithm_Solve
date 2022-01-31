package programmers;

import java.util.*;

//나머지가 1이 되는 수 찾기
//26012022

public class p26012022 {
    public static void main(String[] args) throws Exception {
        Solution27 s = new Solution27();
<<<<<<< HEAD
        int a = 10;
=======

        int a = 10;


>>>>>>> 5cdec7a8c3e214735cda92572945db85cee1ad68
        System.out.println(s.solution(a));

    }
}

class Solution27 {

    public int solution(int n) {
<<<<<<< HEAD

        int a = 1;

=======
        
        int a = 1;
>>>>>>> 5cdec7a8c3e214735cda92572945db85cee1ad68
        while (a<n) {
            if (n%a == 1) {
                break;
            }
            a++;
        }
<<<<<<< HEAD

=======
>>>>>>> 5cdec7a8c3e214735cda92572945db85cee1ad68
        int answer = a;
        return answer;
    }
}