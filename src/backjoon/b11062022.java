package backjoon;

import java.io.*;
import java.util.*;

//구구단
//11062022

public class b11062022 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 1; i < 10; i++) {
      System.out.println(n + " * " + i + " = " + (i * n));
    }

    sc.close();
  }
}
