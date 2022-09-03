package backjoon;

import java.io.*;
import java.util.*;

//전구와 스위치
//03092022

public class b03092022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String c = br.readLine();
        String e = br.readLine();

        int[] current1 = new int[n];
        int[] current2 = new int[n];
        int[] expect = new int[n];
        for (int i = 0; i < n; i++) {
            current1[i] = c.charAt(i) - '0';
            current2[i] = c.charAt(i) - '0';
            expect[i] = e.charAt(i) - '0';
        }

        int ans1 = 1;
        int ans2 = 0;

        current1[0] = 1 - current1[0];
        current1[1] = 1 - current1[1];

        for (int i = 1; i < n; i++) {
            if (current1[i - 1] != expect[i - 1]) {
                current1[i - 1] = 1 - current1[i - 1];
                current1[i] = 1 - current1[i];
                ans1++;
                if (i != n - 1) {
                    current1[i + 1] = 1 - current1[i + 1];
                }

            }
            if (current2[i - 1] != expect[i - 1]) {
                current2[i - 1] = 1 - current2[i - 1];
                current2[i] = 1 - current2[i];
                ans2++;
                if (i != n - 1) {
                    current2[i + 1] = 1 - current2[i + 1];
                }
            }
        }

        if (current1[n - 1] != expect[n - 1]) {
            ans1 = 987654321;
        }
        if (current2[n - 1] != expect[n - 1]) {
            ans2 = 987654321;
        }
        ;

        if (ans1 == 987654321 && ans2 == 987654321) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }
    }
}