package backjoon;

import java.io.*;
import java.util.*;

//Moo 게임
//30082022

public class b30082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int pre = 0;
        int now = 3;
        int mid = 3;

        while (n > now) {
            pre = now;
            now = now * 2 + (mid + 1);
            mid++;
        }

        while (true) {
            if (pre < n && n <= pre + mid) {
                n -= pre;
                break;
            }

            if (n <= pre) {
                now = pre;
                mid--;
                pre = (now - mid) / 2;
            } else {
                now = pre;
                n -= (pre + mid);
                mid--;
                pre = (now - mid) / 2;
            }

        }

        if (n == 1) {
            System.out.println("m");
        } else {
            System.out.println("o");
        }

    }

}