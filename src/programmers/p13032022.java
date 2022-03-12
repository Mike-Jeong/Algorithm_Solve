package programmers;

//import java.util.*;

//이진 변환 반복하기
//13032022

public class p13032022 {
    public static void main(String[] args) throws Exception {

        Solution76 s = new Solution76();

        String a = "110010101001";

       System.out.println(s.solution(a));

    }
}

class Solution76 {

    public int[] solution(String s) {

        int[] answer = new int[2];

        while (s.length() != 1) {
            int origin_length = s.length();
            s = s.replaceAll("0", "");
            int changed_lenght = s.length();

            s = Integer.toBinaryString(changed_lenght);

            answer[0] += 1;
            answer[1] += (origin_length - changed_lenght);
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
}