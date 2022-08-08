package backjoon;

import java.io.*;
import java.util.*;

//물통
//08082022

public class b08082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] bottles = new int[3];

        for (int i = 0; i < 3; i++) {
            bottles[i] = Integer.parseInt(st.nextToken());
        }

        int[] from = { 0, 0, 1, 1, 2, 2 };
        int[] to = { 1, 2, 0, 2, 0, 1 };
        boolean[][] check = new boolean[201][201];
        boolean[] ans = new boolean[201];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0));
        check[0][0] = true;
        ans[bottles[2]] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = bottles[2] - x - y;

            for (int k = 0; k < 6; k++) {
                int[] next = { x, y, z };
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;

                if (next[to[k]] > bottles[to[k]]) {
                    next[from[k]] = next[to[k]] - bottles[to[k]];
                    next[to[k]] = bottles[to[k]];
                }
                if (!check[next[0]][next[1]]) {
                    check[next[0]][next[1]] = true;
                    q.add(new Pair(next[0], next[1]));
                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for (int i = 0; i <= bottles[2]; i++) {
            if (ans[i])
                System.out.print(i + " ");
        }
    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}