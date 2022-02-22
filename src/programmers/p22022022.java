package programmers;

import java.util.*;

//튜플
//22022022

public class p22022022 {
    public static void main(String[] args) throws Exception {
        Solution55 s = new Solution55();

        String a = "200-300-500-600*40+500+500";

        System.out.println(s.solution(a));
    }
}

class Solution55 {

    Long max = (long) 0;

    public long solution(String expression) {

        String[] a_signs = expression.replaceAll("\\w", "").split("");
        String[] a_nums = expression.split("\\D");
        String[][] orders = {{"+","-","*"},{"+","*","-"},{"-","*","+"},{"-","+","*"},{"*","+","-"},{"*","-","+"}};

        for (String[] order : orders) {

            ArrayList<String> signs = new ArrayList<>(Arrays.asList(a_signs));
            ArrayList<String> nums = new ArrayList<>(Arrays.asList(a_nums));

            recursion(order, 0, signs, nums);
        }

        long answer = max;
        return answer;
    }

    public void recursion(String[] order, int index, ArrayList<String> signs, ArrayList<String> nums){

        if (index == 3) {
            Long final_sum = Math.abs(Long.parseLong(nums.get(0)));
            max = Math.max(max, final_sum);
            return;
        }

        String sign = order[index];

        while (signs.contains(sign)) {
            
            Long sum;

            if (sign.equals("+")) {
                sum = (Long.parseLong(nums.get(signs.indexOf(sign))) + Long.parseLong(nums.get(signs.indexOf(sign) + 1)));

            } else if (sign.equals("-")) {
                sum = (Long.parseLong(nums.get(signs.indexOf(sign))) - Long.parseLong(nums.get(signs.indexOf(sign) + 1)));

            } else {
                sum = (Long.parseLong(nums.get(signs.indexOf(sign))) * Long.parseLong(nums.get(signs.indexOf(sign) + 1)));
            }

            nums.set(signs.indexOf(sign), String.valueOf(sum));
            nums.remove(signs.indexOf(order[index]) + 1);
            signs.remove(sign);
        
        }

        recursion(order, index + 1, signs, nums);

    }
}