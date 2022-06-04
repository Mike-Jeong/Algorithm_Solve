package backjoon;

import java.io.*;
import java.util.*;

//조합
//04062022

public class b04062022 {

  public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    long[] fabo = new long[70];

    fabo[0] = 1;
    fabo[1] = 1;
    fabo[2] = 2;
    fabo[3] = 4;

    for (int i = 0; i < N; i++) {

      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());

      for (int j = 4; j <= num; j++) {
        fabo[j] = fabo[j - 1] + fabo[j - 2] + fabo[j - 3] + fabo[j - 4];
      }

      System.out.println(fabo[num]);
      
    }
		
	}
 
}