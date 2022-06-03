package backjoon;

import java.io.*;
import java.util.*;

//조합
//03062022

public class b03062022 {

  public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

    long nf = 1;
    long mf = 1;

    for (int i = m; i > 0; i--) {

      nf *= n;
      mf *= m;

      n -= 1;
      m -= 1;

    }

    System.out.println(nf);
    System.out.println(mf);

    System.out.println(nf/mf);
		
	}
 
}