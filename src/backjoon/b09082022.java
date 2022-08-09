package backjoon;

import java.io.*;
import java.util.*;

//신기한 소수
//09082022

public class b09082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        recursion(0, 0, n);

    }

    public static void recursion(int count, int num, int end) {

        if (count == end) {
            System.out.println(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int n = (num * 10) + i;
            if (isPrime(n)) {
                recursion(count + 1, n, end);
            }
        }
    }

    public static boolean isPrime(int num) {

        int sqrt = (int) Math.sqrt(num);

        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
