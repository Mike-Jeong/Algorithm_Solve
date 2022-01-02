package programmers;

import java.util.*;
//로또의 최고 순위와 최저 순위
//01012022
public class p01012022 {
    public static void main(String[] args) throws Exception {
        
        Solution s = new Solution();
        int[] a = {44, 1, 0, 0, 31, 25};
        int[] b = {31, 10, 45, 1, 6, 19};
        
        int[] ans = s.solution(a, b);

        System.out.println(ans[0] + ", " + ans[1]);
    }
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        Map map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);


        int correct = 0;
        int numof_0 = 0;

        for (int a = 0; a < lottos.length; a++) {
            System.out.println(lottos[a] + "&&&& " + win_nums[a]);
        }

        for (int i = 0; i < lottos.length; i++) {

            if (lottos[i] == 0) {

                numof_0++;
            }

            else{

                for (int j : win_nums) {

                    if (lottos[i] == j) {
                        correct++;
                    }
                }
            }
        
        }
        
        int[] answer = {(int) map.get(correct + numof_0), (int) map.get(correct)};
        return answer;
    }

}