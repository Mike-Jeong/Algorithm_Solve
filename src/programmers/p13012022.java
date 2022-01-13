package programmers;

import java.util.*;

//폰켓몬
//13012022

public class p13012022 {
    public static void main(String[] args) throws Exception {
        Solution15 s = new Solution15();

        int[] a = {3,1,2,3};
        System.out.println(s.solution(a));
    }
}

class Solution15 {

    public int solution(int[] nums) {
        
        int a = nums.length / 2;
        Set<Integer> b = new HashSet<>(); 

        for (int i : nums) {
            b.add(i);
        }

        int answer = Math.min(a, b.size());
        return answer;
    }
}