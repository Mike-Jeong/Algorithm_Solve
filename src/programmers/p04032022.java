package programmers;

//import java.util.*;

//주식가격
//04032022

public class p04032022 {
    public static void main(String[] args) throws Exception {

        Solution65 s = new Solution65();

        int[] a = {1, 2, 3, 2, 3};

        System.out.println(s.solution(a));
    }
}

class Solution65 {

    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            answer[i] = 0;

            for (int j = i + 1; j < prices.length; j++) {

                answer[i]++;

                if (prices[i] > prices[j]) {
                    break;
                }
                
            }
        }
        
        return answer;
    }
}