package programmers;

//import java.util.*;

//내적
//06012022

public class p06012022_02 {
    public static void main(String[] args) throws Exception {
        Solution08 s = new Solution08();

        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2}; 

        System.out.println(s.solution(a,b));
    }
}

class Solution08 {

    public int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < b.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}