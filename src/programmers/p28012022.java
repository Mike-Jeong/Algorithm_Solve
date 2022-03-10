package programmers;

//import java.util.*;

//비밀지도
//28012022

public class p28012022 {
    public static void main(String[] args) throws Exception {
        Solution29 s = new Solution29();

        int a = 6;
        int[] b = {46, 33, 33 ,22, 31, 50};
        int[] c = {27 ,56, 19, 14, 14, 10};

        System.out.println(s.solution(a,b,c));

    }
}

class Solution29 {

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String format = "%" + n + "s";
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format(format, Integer.toBinaryString(arr1[i] | arr2[i]));
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }
        return answer;
    }
}