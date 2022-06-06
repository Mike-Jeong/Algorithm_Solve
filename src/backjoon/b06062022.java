package backjoon;

import java.io.*;
import java.util.*;

//악수
//06062022

public class b06062022 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int num = Integer.parseInt(st.nextToken());

    if (num < 3) {
      if (num == 1) {
        System.out.println(1);
      }

      if (num == 2) {
        System.out.println(2);
      }
    } else {
      int[] dp = new int[num + 1];

      dp[1] = 1;
      dp[2] = 2;

      for (int i = 3; i < dp.length; i++) {
        dp[i] = (dp[i - 1] + dp[i -2]) % 10;
      }

      System.out.println(dp[num]);
    }
   
    
  }
}