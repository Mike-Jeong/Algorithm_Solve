package programmers;

import java.util.*;

//K번째수
//10012022

public class p10012022 {
    public static void main(String[] args) throws Exception {
        Solution12 s = new Solution12();

        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(s.solution(a, b));
    }
}

class Solution12 {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] is : commands) {
            
            int[] narray = new int[is[1] - is[0] + 1];

            for (int i = 0; i < is[1] - is[0] + 1; i++) {
                narray[i] = array[is[0]-1+i];
            }

            Arrays.sort(narray);
            answer[index] = narray[is[2]-1];
            index++;

        }
        return answer;
    }
}