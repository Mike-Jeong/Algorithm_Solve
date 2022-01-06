package programmers;

import java.util.*;

//음양 더하기
//06012022

public class p06012022 {
    public static void main(String[] args) throws Exception {
        Solution07 s = new Solution07();

        int[] a = {4,7,12};
        boolean[] b = {true,false,true}; 

        System.out.println(s.solution(a,b));
    }
}

class Solution07 {

    public int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            
            if(!signs[i]) {

                answer -= absolutes[i];
            }
            else{

                answer += absolutes[i];
            }
        }

        return answer;
    }
}