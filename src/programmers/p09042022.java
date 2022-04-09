package programmers;

import java.util.*;

//이중우선순위큐
//09042022

public class p09042022 {

    public static void main(String[] args) throws Exception {

        Solution100 s = new Solution100();

        String[] a = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };

        System.out.println(s.solution(a));

    }
}

class Solution100 {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue_r = new PriorityQueue<>(Collections.reverseOrder());

        for (String orders : operations) {
            String[] order = orders.split(" ");
            String tag = order[0];

            if (tag.equals("I")) {
                priorityQueue.add(Integer.parseInt(order[1]));
                priorityQueue_r.add(Integer.parseInt(order[1]));
            } else {
                if (!priorityQueue.isEmpty()) {
                    if (order[1].equals("1")) {
                        int target = priorityQueue_r.poll();
                        priorityQueue.remove(target);
                    } else {
                        int target = priorityQueue.poll();
                        priorityQueue_r.remove(target);
                    }
                }
            }
        }

        if (priorityQueue.isEmpty()) {
            return new int[] { 0, 0 };
        } else {
            return new int[] { priorityQueue_r.poll(), priorityQueue.poll() };
        }

    }
}