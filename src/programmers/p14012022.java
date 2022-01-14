package programmers;

import java.util.*;
import java.util.stream.Collectors;

//실패율
//14012022

public class p14012022 {
    public static void main(String[] args) throws Exception {
        Solution16 s = new Solution16();

        int a = 5;
        int[] b = { 2, 1, 2, 6, 2, 4, 3, 3 };
        System.out.println(s.solution(a, b));
    }
}

class Solution16 {

    public int[] solution(int N, int[] stages) {

        int c_num = stages.length;
        List<Integer> stage = Arrays.stream(stages).boxed().collect(Collectors.toList());
        Double[] sort_failrate = new Double[N];
        List<Double> failrate = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            int fail = 0;

            for (int j : stage) {
                if (j == i+1) {
                    fail++;
                }
            }

            double frate;

            if (fail != 0) {
                frate = (double) fail / (double)c_num;
            } else {
                frate = 0;
            }

            failrate.add(frate);

            sort_failrate[i] = frate;

            c_num -= fail;

        }

        Arrays.sort(sort_failrate, Collections.reverseOrder());

        int[] answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = failrate.indexOf(sort_failrate[i]) + 1;
            failrate.set(answer[i] - 1, -1.0);
        }

        return answer;
    }
}