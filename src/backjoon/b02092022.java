package backjoon;

import java.io.*;
import java.util.*;

//리모컨
//02092022

public class b02092022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        boolean[] broken = new boolean[10];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int button = Integer.parseInt(st.nextToken());

            broken[button] = true;
        }

        int result = Math.abs(n - 100);
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            
            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true; 
                    break;
                }
            }
            if(!isBreak) {
                int min = Math.abs(n - i) + len; 
                result = Math.min(min, result);
            }
        }        
        System.out.println(result);

    }
}