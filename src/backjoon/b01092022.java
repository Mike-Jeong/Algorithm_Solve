package backjoon;

import java.io.*;
import java.util.*;

//토마토
//01092022

public class b01092022 {

    static int[] rowOrder = { -1, 1, 0, 0 };
    static int[] colOrder = { 0, 0, -1, 1 };
    static int[][] map;
    static int n;
    static int m;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[] { i, j });
                }
            }
        }

        System.out.println(recursion());

    }

    private static int recursion() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            for (int i = 0; i < 4; i++) {

                try {
                    int nx = x + rowOrder[i];
                    int ny = y + colOrder[i];
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[] { nx, ny });
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if (checkZero()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }

            return max - 1;
        }

    }

    private static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}