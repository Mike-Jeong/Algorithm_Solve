package programmers;

import java.util.*;

//키패드 누르기
//04012022

public class p05012022 {
    public static void main(String[] args) throws Exception {
        Solution04 s = new Solution04();

        int[] a = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; 

        System.out.println(s.solution(a,"left"));
    }
}

class Solution04 {
    public String solution(int[] numbers, String hand) {

        int[][] p = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};

        Map<Integer, int[]> n_to_p = new HashMap<Integer, int[]>();

        n_to_p.put(1, p[1]);
        n_to_p.put(2, p[2]);
        n_to_p.put(3, p[3]);
        n_to_p.put(4, p[4]);
        n_to_p.put(5, p[5]);
        n_to_p.put(6, p[6]);
        n_to_p.put(7, p[7]);
        n_to_p.put(8, p[8]);
        n_to_p.put(9, p[9]);
        n_to_p.put(0, p[0]);
        n_to_p.put(10, p[10]);
        n_to_p.put(11, p[11]);

        Map<Integer, Character> hp = new HashMap<Integer, Character>();

        hp.put(1, 'L');
        hp.put(3, 'R');
        hp.put(4, 'L');
        hp.put(6, 'R');
        hp.put(7, 'L');
        hp.put(9, 'R');

        int left = 10;
        int right = 11;
        String answer = "";
       
        StringBuilder newString = new StringBuilder(answer);

        for (int num : numbers) {


            try {

                char result = hp.get(num);
                newString.append(result);

                if (result == 'L') {
                    left = num;
                } else {
                    right = num;
                }


                
            } catch (Exception e) {
                
                int[] a = n_to_p.get(num);
                int[] b = n_to_p.get(left);
                int[] c = n_to_p.get(right);

                if ((Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1])) > (Math.abs(a[0]-c[0]) + Math.abs(a[1]-c[1]))) {
                    
                    newString.append('R');
                    right = num;
                } 

                else if ((Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1])) < (Math.abs(a[0]-c[0]) + Math.abs(a[1]-c[1]))) {
                    newString.append('L');
                    left = num;
                } 
                
                else {
                    
                    if (hand.equals("right")) {
                        newString.append('R');
                        right = num;
                    }
                    else{
                        newString.append('L');
                        left = num;
                    }

                }


            }

        }

        answer = newString.toString();


       


        return answer;
    }
}