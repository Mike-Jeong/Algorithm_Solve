package backjoon;

import java.io.*;
//import java.util.*;

//피자
//18062022

public class b18062022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.print((n*n-n)/2); // 더 쉬운 점화식이 존재했음.....

    }
}

/*
 
import java.io.*;
import java.util.*;

//피자
//18062022

public class b18062022 {

    static long[] dp;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(0);
        } else {

            dp = new long[n + 1];
            dp[2] = 1;

            recursion(n);

            System.out.println(dp[n]);
        }

        sc.close();
    }

    static long recursion(int num) {

        if (dp[num] != 0 || num == 1) {

            if (num == 1) {
                return 0;
            }

            return dp[num];
        }

        int half = num / 2;
        dp[num] = (half * (num - half)) + recursion(half) + recursion(num - half);

        return dp[num];

    }
}
 // 맞긴 맞는데, 메모리 초과 남
 */