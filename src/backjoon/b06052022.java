package backjoon;

import java.io.*;
import java.util.*;

//소수 찾기
//06052022

public class b06052022 {

    public static void main(String[] args) throws IOException {

        boolean[] num = new boolean[1000001];

        num[0] = true;
        num[1] = true;

        for (int i = 2; i <= Math.sqrt(num.length - 1); i++) {
            for (int j = i + i; j <= num.length - 1; j += i) {
                num[j] = true;
            }
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int s = Integer.valueOf(st.nextToken());
        int e = Integer.valueOf(st.nextToken());

        for (int i = s; i <= e; i++) {
           if (!num[i]) {
               System.out.println(i);
           }
        }
    }

}
