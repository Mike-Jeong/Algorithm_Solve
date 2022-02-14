package programmers;

import java.util.*;

//프린터
//14022022

public class p14022022 {
    public static void main(String[] args) throws Exception {
        Solution47 s = new Solution47();

        int[] a = {2,1,3,2};
        int b = 2;
        //1

        System.out.println(s.solution(a,b));
    }
}

class Solution47 {

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> order = new LinkedList<>();
        List<Integer> f_order = new ArrayList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            order.add(i);
        }

        while (!order.isEmpty()) {
            int index = order.poll();
            int target = priorities[index];
            if (queue.peek() == target) {
                queue.poll();
                f_order.add(index);
            }
            else{
                order.add(index);
            }
        }

        int answer = f_order.indexOf(location) + 1;
        return answer;
    }
}