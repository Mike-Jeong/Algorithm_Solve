package backjoon;

import java.io.*;
//import java.util.*;

//공통 부분 문자열
//29082022

public class b29082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int max = 0;
        int[][] map = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                    max = Math.max(max, map[i][j]);
                }
            }
        }

        System.out.println(max);

    }

}