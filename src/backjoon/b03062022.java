package backjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

//조합
//03062022

public class b03062022 {

  public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

    BigInteger nf = new BigInteger("1");
    BigInteger mf = new BigInteger("1");

    for (int i = m; i > 0; i--) {

      nf = nf.multiply(BigInteger.valueOf(n));
      mf = mf.multiply(BigInteger.valueOf(m));
      
      n -= 1;
      m -= 1;
    }

    System.out.println(nf.divide(mf));
		
	}
 
}