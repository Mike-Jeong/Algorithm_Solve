package programmers;

//import java.util.*;

//카펫
//02032022

public class p02032022 {
    public static void main(String[] args) throws Exception {

        Solution63 s = new Solution63();

        int a = 10;
        int b = 2;

        System.out.println(s.solution(a,b));
    }
}

class Solution63 {

    int cover;
    int inside;

    public int[] solution(int brown, int yellow) {
        cover = brown;
        inside = yellow;
        int num_tile = yellow + brown;
        int[] answer = new int[2];

        for (int i = 2; i < num_tile / 2; i++) {
            if (num_tile % i == 0) {
                if (check(i, num_tile/i)) {
                    answer[0] = Math.max(i, num_tile/i);
                    answer[1] = Math.min(i, num_tile/i);
                    break;
                }
            }
        }
        return answer;
    }

    public boolean check(int width, int height){

        int out = 2*(width + height) - 4;
        int in = (width - 2) * (height - 2);
        if (out == cover && in == inside) {
            return true;
        }

        return false;
    }
}