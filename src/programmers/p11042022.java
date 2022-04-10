package programmers;

//import java.util.*;

//2 x n 타일링
//11042022

public class p11042022 {

    public static void main(String[] args) throws Exception {

        Solution102 s = new Solution102();

        int a = 4;

        System.out.println(s.solution(a));

    }
}

class Solution102 {

    int target;
    int count = 0;

    public int solution(int n) {

        target = n;
        recursion(0);

        return count;
    }

    public void recursion(int sum) {

        if (sum >= target) {
            if (sum == target) {
                count++;
            }

            return;
        }

        recursion(sum + 1);

        recursion(sum + 2);

    }
}