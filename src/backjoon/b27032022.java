package backjoon;

import java.io.*;
import java.util.*;



//빙산
//27032022

public class b27032022 {

    static int[][] ice;
    static boolean[][] visited;
    static Queue<Integer> queue0 = new LinkedList<>();
    static Queue<Integer> queue1 = new LinkedList<>();
    static int[] order_row = { -1, 0, 1, 0 };
    static int[] order_col = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ice = new int[n][m];
        visited = new boolean[ice.length][ice[0].length];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {

            int count = 0;
            int count_i = 0;
            visited = new boolean[ice.length][ice[0].length];

            for (int i = 0; i < ice.length; i++) {
                for (int j = 0; j < ice[0].length; j++) {
                    if (ice[i][j] != 0 && !visited[i][j]) {
                        queue0.add(i);
                        queue1.add(j);
                        while (!queue0.isEmpty()) {
                            bfs();
                            count_i++;
                        }
                        count++;
                    }
                }
            }

            if (count >= 2 || count_i == 0) {

                if (count_i == 0) {
                    year = 0;
                }
                break;
            }

            year++;
        }

        System.out.println(year);

    }

    public static void bfs() {

        int row = queue0.poll();
        int col = queue1.poll();

        if (!visited[row][col]) {

            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {
                try {
                    if (ice[row + order_row[i]][col + order_col[i]] != 0) {
                        if (!visited[row + order_row[i]][col + order_col[i]]) {
                            queue0.add(row + order_row[i]);
                            queue1.add(col + order_col[i]);
                        }

                    } else {

                        if (!visited[row + order_row[i]][col + order_col[i]]) {
                            if (ice[row][col] > 0) {
                                ice[row][col]--;
                            }
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }
}

