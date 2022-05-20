package programmers;

import java.util.*;

//?
//19052022

public class p19052022 {

    public static void main(String[] args) throws Exception {

        Solution110 s = new Solution110();

        int[] a = { 7, 10, 4, 5 };
        int[] b = { 5, 4, 3, 1 };
        int[] c = { 4, 6, 2, 8 };

        System.out.println(s.solution(a, b, c));

    }
}

class Solution110 {

    public int solution(int[] amount, int[] value, int[] stomach) {

        PriorityQueue<int[]> amount_value = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return 1;
                } else if (o1[1] > o2[1]) {
                    return -1;
                } else {
                    return o1[0] > o2[0] ? 1 : -1;
                }
            }
        });

        for (int i = 0; i < amount.length; i++) {
            amount_value.add(new int[] { amount[i], value[i] });
        }

        int answer = 0;

        int count = 0;
        int peo = stomach.length;

        while (!amount_value.isEmpty()) {

            int[] now = amount_value.poll();

            if (now[0] < peo) {
                continue;

            }

            if (count == 0) {
                
                int cal = now[0] / peo;
                if (cal > 0) {
                    answer += (now[1] * cal * peo);
                    count++;
                }
                System.out.println(answer);

            } else {

                boolean con = true;
                while (con) {
                    
                    if (now[0] >= peo) {
                        for (int i = 0; i < stomach.length; i++) {
                            if(stomach[i] != 0){
                                stomach[i]--;
                                now[0]--;
                                answer += now[1];
                            }
                        
                            if (stomach[i] == 0) {
                                peo--;
                            }

                            if (now[0] == 0) {
                                con  = false;
                            }
    
                            
                        }
                    } else break;
                    
                }
            }

        }

        return answer;
    }
}

/*
 * public class p19052022 {
 * 
 * public static void main(String[] args) throws Exception {
 * 
 * Solution110 s = new Solution110();
 * 
 * int[] a = {7, 10, 4, 5};
 * int[] b = {5, 4, 3, 1};
 * int[] c = {4, 6, 2, 8};
 * 
 * System.out.println(s.solution(a, b, c));
 * 
 * }
 * }
 * 
 * class Solution110 {
 * 
 * public int solution(int[] amount, int[] value, int[] stomach) {
 * int answer = 0;
 * return answer;
 * }
 * }
 */