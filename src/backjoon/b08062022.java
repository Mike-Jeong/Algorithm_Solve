package backjoon;

import java.io.*;
import java.util.*;

//Tetrahedral Stacks of Cannonballs
//08062022

public class b08062022 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int loop = sc.nextInt();

    int[] lastballs = new int[1001];
    int[] sums = new int[1001];

    lastballs[1] = 1;
    sums[1] = 1;

    for (int i = 0; i < loop; i++) {
      int num = sc.nextInt();

      if (sums[num] == 0) {

        for (int j = 2; j <= num; j++) {
          lastballs[j] = lastballs[j - 1] + j;
          sums[j] = sums[j-1] + lastballs[j];
        }
      }

      System.out.println((i + 1) + ": " + num + " " + sums[num]);
    }

   sc.close();
    
  }
}