package backjoon;

import java.io.*;
import java.util.*;

//공약수
//28082022

public class b28082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        int lcd = Integer.parseInt(st.nextToken());

        long mul = (long) gcd * lcd;

        int a = 0, b = 0;

        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0 && euclidean(i, mul / i) == gcd) {
                a = i;
                b = (int) (mul / i);
            }
        }

        System.out.println(a + " " + b);
    }

    // 유클리드 호제법
    public static long euclidean(long a, long b) {
        long r = a % b;
        if (r == 0) {
            return b;
        }
        return euclidean(b, r);
    }

}