package programmers;

import java.util.*;
import java.util.stream.Collectors;

//가장 큰 수
//23022022

public class p23022022 {
    public static void main(String[] args) throws Exception {
        Solution56 s = new Solution56();

        int[] a = { 6, 10, 2 };

        System.out.println(s.solution(a));
    }
}

class Solution56 {

    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            nums[i] = numbers[i] + "";
 
        Arrays.sort(nums, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
 
        return nums[0].equals("0") ? "0" : Arrays.stream(nums).collect(Collectors.joining());
    }// 인터넷 퍼옴
}

//메모리 초과, 런타임 에러
/*
class Solution56 {

    PriorityQueue<Long> a = new PriorityQueue<>(Collections.reverseOrder()); 

    public String solution(int[] numbers) {

        Queue<Integer> nums = new LinkedList<>();

        for (int i : numbers) {
            nums.add(i);
        }

        recursion(nums, "");

        String answer = String.valueOf(a.poll());
        return answer;
    }

    public void recursion(Queue<Integer> nums, String s) {

        if (nums.isEmpty()) {

            a.add(Long.parseLong(s));
            return;
        }
        
        int count = 0;

        while (count != nums.size()) {
            StringBuilder sb = new StringBuilder(s);
            int target = nums.poll();
            sb.append(target);
            recursion(nums, sb.toString());
            nums.add(target);
            count ++;
        }

    }
}
*/