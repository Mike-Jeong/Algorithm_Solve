package programmers;

import java.util.*;

//위장
//05032022

public class p05032022 {
    public static void main(String[] args) throws Exception {

        Solution66 s = new Solution66();

        String[][] a = { {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"} };

        System.out.println(s.solution(a));
    }
}

class Solution66 {

    public int solution(String[][] clothes) {

        Map<String,Integer> set = new HashMap<>();

        for (String[] strings : clothes) {
            
            if (set.containsKey(strings[1])) {
                set.replace(strings[1], set.get(strings[1]), set.get(strings[1]) + 1);
            }
            else{
                set.put(strings[1], 1);
            }
        }

        int count = 0;
        int combi = 1;

        for (String strings : set.keySet()) {
            count += set.get(strings);
            combi *= set.get(strings) + 1;
        }

        if (set.size() != 1) {
            return combi - 1;
        } else {
            return count;
        }
    }
}