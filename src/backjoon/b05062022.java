package backjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

//이항 계수 2
//05062022

public class b05062022 {

  static BigInteger[] factorial;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
  
    BigInteger K = BigInteger.valueOf(k); 

    if (K.equals(BigInteger.ZERO)) {
      System.out.println(1);
    } else {

      factorial = new BigInteger[n + 1];
      factorial[0] = BigInteger.ONE;
      factorial[1] = BigInteger.ONE;
  
      Fator(n);

      BigInteger ans = factorial[n].divide(factorial[k].multiply(factorial[n - k])).remainder(BigInteger.valueOf(10007));
  
      System.out.println(ans);

    }
  }

  static BigInteger Fator(int index) {


    if (factorial[index] != null) {
      return factorial[index];
    }

    factorial[index] = BigInteger.valueOf(index).multiply(Fator(index - 1));

    return factorial[index];
  }

}