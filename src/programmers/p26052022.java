package programmers;

import java.util.*;

//?
//26052022

public class p26052022 {

    public static void main(String[] args) throws Exception {

        Solution111 s = new Solution111();

        System.out.println(s.solution("145670126196322518840135821983556575493101506424374"));
        System.out.println("---------------------------------------------------------");
        System.out.println(s.solution("49116165281446727117319003073497380461301921065340845514989233144382233615377997611611"));
        System.out.println("---------------------------------------------------------");
        System.out.println(s.solution("00000000000000000000"));
        System.out.println("---------------------------------------------------------");
        System.out.println(s.solution("010102030508013021034055089014402330377061009870159702584041811"));
        System.out.println("---------------------------------------------------------");
        System.out.println(s.solution("101001102103205308501380223036105840945015290247404003064770104800169570274370443940"));
        System.out.println("---------------------------------------------------------");
        System.out.println(s.solution("14152944"));
        System.out.println("---------------------------------------------------------");
        System.out.println(s.solution("1501515304575"));
        System.out.println("---------------------------------------------------------");

    }
}

class Solution111 {

    int max = Integer.MAX_VALUE;

    public int[] solution(String nums) {

        List<Integer> res = new ArrayList<>();

        recursion(res, nums);

        int[] answer = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    void recursion(List<Integer> list, String s) {

        if (s.equals("") && list.size() > 2 && check(list)) {

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            return;
        }

        for (int i = 1; i <= s.length(); i++) {

            if (s.startsWith("0") && i > 1) {
                return;
            }

            List<Integer> newlist = new ArrayList<>(list);

            long num = Long.parseLong(s.substring(0, i));

            if (num > max) {
                return;
            }

            newlist.add((int)num);

            if (check(list)) {
                recursion(newlist, s.substring(i));
            }
        }
    }

    boolean check(List<Integer> list){

        if (list.size() < 3) {
            return true;
        }

        int size = list.size() - 1;

        return list.get(size) == list.get(size - 1) + list.get(size - 2);

    }

}
