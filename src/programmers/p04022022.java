package programmers;

import java.util.*;

//타겟 넘버
//04022022

public class p04022022 {
    public static void main(String[] args) throws Exception {
        Solution36 s = new Solution36();

        int[] a = {1, 1, 1, 1, 1};
        int b = 3;

        System.out.println(s.solution(a, b));
    }
}

class Solution36 {

    int target;
    int[] numbers;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        recursion(0, 0);

        return answer;
    }

    void recursion(int sum, int index)
    {
        if (index == numbers.length) {
            if (sum == target) {
                answer ++;
            }
            return;
        }

        sum += numbers[index];

        recursion(sum, index+1);

        sum -= (2 * numbers[index]);

        recursion(sum, index + 1);



    }
}