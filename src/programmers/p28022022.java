package programmers;

import java.util.*;

//최댓값과 최솟값
//28022022

public class p28022022 {
    public static void main(String[] args) throws Exception {

        Solution61 s = new Solution61();

        String a = "1 2 3 4";

        System.out.println(s.solution(a));
    }
}

class Solution61 {

    public String solution(String s) {

        String[] nums_s = s.split(" ");
        int[] nums = new int[nums_s.length];

        int i = 0;
        for (String string : nums_s) {
            nums[i] = Integer.parseInt(string);
            i++;
        }

        Arrays.sort(nums);

        String answer = String.valueOf(nums[0]) + " " + String.valueOf(nums[nums.length - 1]);
        return answer;
    }
}