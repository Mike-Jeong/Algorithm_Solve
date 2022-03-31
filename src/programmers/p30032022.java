package programmers;

//import java.util.*;

//N개의 최소공배수
//30032022

public class p30032022 {

    public static void main(String[] args) throws Exception {

        Solution94 s = new Solution94();

        int[] a = { 2, 6, 8, 14 };

        System.out.println(s.solution(a));

    }
}

class Solution94 {

    public int solution(int[] arr) {

        int n = arr[0];
        for (int i = 1; i < arr.length; i++) {
            n = (n * arr[i]) / gcd(Math.min(n, arr[i]), Math.max(n, arr[i]));
        }

        return n;
    }

    public int gcd(int a, int b) {

        int c;
        while (b != 0) {
            c = a%b;
            a= b;
            b = c;
        }
        return a;
    }
}