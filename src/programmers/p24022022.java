package programmers;

import java.util.*;

//소수 찾기
//24022022

public class p24022022 {
    public static void main(String[] args) throws Exception {
        Solution57 s = new Solution57();

        String a = "1231";

        System.out.println(s.solution(a));
    }
}

class Solution57 {

    Set<Integer> nums = new HashSet<>();

    public int solution(String numbers) {

        Queue<Integer> queue_init = new LinkedList<>();

        for (int i = 0; i < numbers.length(); i++) {
            int num = Character.getNumericValue(numbers.charAt(i));
            queue_init.add(num);
        }

        recursion(queue_init, 0);

        return nums.size();
    }

    public void recursion(Queue<Integer> queue, int sum) {

        if (queue.isEmpty()) {
            return;
        }

        for (int i = 0; i < queue.size(); i++) {
            int num_queue = queue.poll();
            int target_num = sum * (int) Math.pow(10, 1) + num_queue;

            if (target_num != 0 && target_num != 1) {
                boolean check = true;

                for (int j = 2; j < target_num / 2 + 1; j++) {
                    if (target_num % j == 0) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    nums.add(target_num);
                }
            }
            recursion(queue, target_num);
            queue.add(num_queue);
        }

    }

}
