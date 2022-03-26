package programmers;

//import java.util.*;

//k진수에서 소수 개수 구하기
//26032022

public class p26032022 {

    public static void main(String[] args) throws Exception {

        Solution91 s = new Solution91();

        int a = 437674;
        int b = 3;
        System.out.println(s.solution(a, b));

    }
}

class Solution91 {

    public int solution(int n, int k) {

        StringBuilder sb = new StringBuilder();
        int answer = 0;

        while (n != 0) {
            int num = (n % k);
            sb.insert(0, num);
            n /= k;
        }

        String[] ck = sb.toString().split("0");

        for (String string : ck) {

            if (!string.isEmpty()) {

                Long target = Long.parseLong(string);

                if (target != 1) {

                    boolean p_ck = true;

                    if (target != 2 && target != 3) {
                        for (int i = 2; i < (long) Math.sqrt(target) + 1; i++) {
                            if (target % i == 0) {
                                p_ck = false;
                                break;
                            }
                        }
                    }
                    if (p_ck) {
                        answer++;
                    }
                }

            }
        }

        return answer;
    }
}