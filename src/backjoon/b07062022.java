package backjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

//Virus outbreak
//07062022

public class b07062022 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    BigInteger[] dp = new BigInteger[491];

    dp[1] = BigInteger.ONE;
    dp[2] = BigInteger.ONE;

    while (true) {

      int num = sc.nextInt();

      if (num == -1) {
        sc.close();
        break;
      }

      if (dp[num] != null) {
        System.out.println("Hour " + num + ": " + dp[num] + " cow(s) affected");
      } else {
        for (int i = 3; i <= num; i++) {
          dp[i] = dp[i - 1].add(dp[i - 2]); 
        }

        System.out.println("Hour " + num + ": " + dp[num] + " cow(s) affected");
      }
    }

  }
}