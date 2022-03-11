package programmers;

import java.util.*;

//최솟값 만들기
//11032022

public class p11032022_02 {
    public static void main(String[] args) throws Exception {

        Solution74 s = new Solution74();

        int[] a = {};
        int[] b = {};

        System.out.println(s.solution(a, b));
    }
}

class Solution74 {

    public int solution(int[] A, int[] B) {

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int mult = A[i] * B[B.length - 1 - i];
            answer += mult;
        }

        return answer;
    }
}