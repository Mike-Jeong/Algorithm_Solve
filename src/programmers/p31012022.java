package programmers;

import java.util.*;

//다트 게임
//30012022

public class p31012022 {
    public static void main(String[] args) throws Exception {
        Solution32 s = new Solution32();
        int[] a = { 1, 1, 3, 3, 0, 1, 1 }; // [1,3,0,1]
        System.out.println(s.solution(a));

    }
}

class Solution32 {

    public int[] solution(int[] arr) {

        List<Integer> nums = new ArrayList<>();

        for (Integer integer : arr) {

            if (nums.size() == 0 || nums.get(nums.size() - 1) != integer) {
                nums.add(integer);
            }
        }

        int[] answer = new int[nums.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = nums.get(i);
        }

        return answer;
    }

}