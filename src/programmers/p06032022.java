package programmers;

import java.util.*;

//다리를 지나는 트럭
//06032022

public class p06032022 {
    public static void main(String[] args) throws Exception {

        Solution67 s = new Solution67();

        int a = 2;
        int b = 10;
        int[] c = { 7, 4, 5, 6 };

        System.out.println(s.solution(a, b, c));
    }
}

class Solution67 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> onbridge = new LinkedList<>();
        int count = 0;
        int current_weight = 0;

        for (Integer integer : truck_weights) {
            queue.add(integer);
        }

        for (int i = 0; i < bridge_length; i++) {
            onbridge.add(0);
        }

        while (!queue.isEmpty()) {

            count++;

            current_weight -= onbridge.poll();

            if (queue.peek() + current_weight <= weight) {
                current_weight += queue.peek();
                onbridge.add(queue.poll());

            } else {
                onbridge.add(0);
            }

        }

        int answer = count + bridge_length;
        return answer;
    }
}