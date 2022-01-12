package programmers;

import java.util.*;
import java.util.stream.Collectors;

//체육복
//12012022

public class p12012022 {
    public static void main(String[] args) throws Exception {
        Solution14 s = new Solution14();

        int n = 24;
        int[] a = { 12, 13, 16, 17, 19, 20, 21, 22 };
        int[] b = { 1, 22, 16, 18, 9, 10 };

        int n1 = 5;
        int[] a1 = { 3, 5 };
        int[] b1 = { 2, 4 };

        // System.out.println(s.solution(n, a, b));
        System.out.println(s.solution(n1, a1, b1));
    }
}

class Solution14 {

    public int solution(int n, int[] lost, int[] reserve) {

        List<Integer> losts = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> templosts = new ArrayList<>();
        templosts.addAll(losts);
        List<Integer> reserves = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        losts.removeAll(reserves);
        reserves.removeAll(templosts);

        int save = 0;
        for (Integer integer : losts) {

            if (reserves.contains((Integer) integer + 1) || reserves.contains((Integer) integer - 1)) {

                if (losts.contains((Integer) integer + 2)) {
                    if (!reserves.remove((Integer) (integer - 1))) {
                        reserves.remove((Integer) (integer + 1));
                    }
                }

                else {
                    if (!reserves.remove((Integer) (integer + 1))) {
                        reserves.remove((Integer) (integer - 1));
                    }
                }
                save++;
            }
        }
        int answer = n - losts.size() + save;
        return answer;
    }
}