package programmers;

import java.util.*;

//기능개발
//03022022

public class p03022022 {
    public static void main(String[] args) throws Exception {
        Solution35 s = new Solution35();

        int[] a = { 96,94 };
        int[] b = { 3,3};

        System.out.println(s.solution(a, b));
    }
}

class Solution35 {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> return_list = new LinkedList<>();
        int head = (int) Math.ceil(((double)(100 - progresses[0]) / (double) speeds[0]));
        int count = 0;

        for (int i = 0; i < progresses.length; i++) {

            if (((int) Math.ceil(((double)(100 - progresses[i]) / (double) speeds[i])) <= head)) {
                count++;
            }

            else {
                return_list.add(count);
                head = (int) Math.ceil(((double)(100 - progresses[i]) / (double) speeds[i]));
                count = 1;
            }
        }

        return_list.add(count);

        int[] answer = new int[return_list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = return_list.get(i);
        }

        return answer;
    }
}