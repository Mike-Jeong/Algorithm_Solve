package backjoon;

import java.io.*;
import java.util.*;

//치킨 TOP N
//23052022

public class b23052022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int round = 1;
        int group_a = (int) Math.ceil((double) a / 2);
        int group_b = (int) Math.ceil((double) b / 2);

        while (group_a != group_b) {

            group_a = (int) Math.ceil((double) group_a / 2);
            group_b = (int) Math.ceil((double) group_b / 2);
            round++;
        }

        if (round > num) {
            System.out.println(-1);
        }

        System.out.println(round);

    }
}