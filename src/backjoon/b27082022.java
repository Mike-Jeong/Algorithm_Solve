package backjoon;

import java.io.*;
import java.util.*;

//0 만들기
//27082022

public class b27082022 {

    static int n;
    static StringBuilder sb;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            sb = new StringBuilder();
            recursion(1, 1, 0, 1, "1");
            System.out.println(sb);

        }
    }

    public static void recursion(int idx, int num, int sum, int o, String s) {

        if (idx == n) {

            sum += (num * o);

            if (sum == 0) {
                sb.append(s + "\n");
            }

            return;
        }

        recursion(idx + 1, num * 10 + (idx + 1), sum, o, s + " " + (idx + 1));
        recursion(idx + 1, idx + 1, sum + (num * o), 1, s + "+" + (idx + 1));
        recursion(idx + 1, idx + 1, sum + (num * o), -1, s + "-" + (idx + 1));

    }
}
