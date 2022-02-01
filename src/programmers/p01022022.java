package programmers;

import java.util.*;

//나누어 떨어지는 숫자 배열
//01022022

public class p01022022 {
    public static void main(String[] args) throws Exception {
        Solution33 s = new Solution33();
        int[] a = {5, 9, 7, 10}; // [1,3,0,1]
        int b = 5;
        System.out.println(s.solution(a, b));

    }
}

class Solution33 {

    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> nums = new LinkedList<>();
        int[] answer;

        for (Integer integer : arr) {
            
            if (integer % divisor == 0) {
                nums.add(integer);
            }
        }
        
        if (nums.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        Collections.sort(nums);

        answer = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            answer[i] = nums.get(i);
        }
        
        return answer;
    }
}