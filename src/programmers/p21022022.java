package programmers;

import java.util.*;

//튜플
//21022022

public class p21022022 {
    public static void main(String[] args) throws Exception {
        Solution54 s = new Solution54();

        String a = "{{20,111},{111}}";

        System.out.println(s.solution(a));
    }
}

class Solution54 {

    public int[] solution(String s) {
        Map<Integer, Set<Integer>> sequence = new HashMap<>();
        Set<Integer> nums = new HashSet<>();

        s = s.replace("{", "").replace("}", " ");
        String[] a = s.split(" ");

        for (String string : a) {

            String[] b = string.split(",");

            Set<Integer> tuple = new HashSet<>();

            for (String string2 : b) {

                if (!string2.isEmpty()) {
                    
                    tuple.add(Integer.parseInt(string2));
                }
            }

            sequence.put(tuple.size(), tuple);
        }

        int[] answer = new int[sequence.size()];

        for (int i = 0; i < answer.length; i++) {

            for (int num : sequence.get(i + 1)) {
                
                if (!nums.contains(num)) {
                    answer[i] = num;
                    nums.add(num);
                    break;
                }
            }
        }
        
        return answer;
    }
}