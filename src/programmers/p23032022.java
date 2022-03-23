package programmers;

//import java.util.*;

//하샤드 수
//23032022

public class p23032022 {

    public static void main(String[] args) throws Exception {

        Solution88 s = new Solution88();

        int a = 11;

        System.out.println(s.solution(a));

    }
}

class Solution88 {

    public boolean solution(int x) {

        int num = x;
        int sum = 0;

        while (num != 0) {

            sum += (num % 10);
            num = num / 10;
        }

        sum += num;

        if ((x % sum) == 0) {
            return true;
        }

        return false;
    }
}