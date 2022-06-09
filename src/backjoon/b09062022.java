package backjoon;

import java.io.*;
import java.util.*;

//피보나치 수 2
//09062022

public class b09062022 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    long[] dp = new long[num + 1];

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= num; i++) {
      dp[i] = dp[i -1] + dp[i -2];
    }

    System.out.println(dp[num]);

    sc.close();

  }
}