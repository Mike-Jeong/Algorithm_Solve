package backjoon;

import java.io.*;
import java.util.*;

//좀비 바이러스
//06042022

public class b06042022 {

    static int[][] map;
    static int[][] time;
    static Queue<Integer> queue0 = new LinkedList<>();
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    static int[] order_row = { -1, 0, 1, 0 };
    static int[] order_col = { 0, -1, 0, 1 };

      public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        time = new int[R][C];

        int[] virus_one = new int[2];
        int[] virus_two = new int[2];
        ;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    virus_one[0] = i;
                    virus_one[1] = j;
                } else if (map[i][j] == 2) {
                    virus_two[0] = i;
                    virus_two[1] = j;
                }
            }
        }

        queue0.add(virus_one[0]);
        queue1.add(virus_one[1]);
        queue2.add(1);

        while (!queue0.isEmpty()) {
            bfs_a();
        }

        queue0.add(virus_two[0]);
        queue1.add(virus_two[1]);
        queue2.add(1);

        while (!queue0.isEmpty()) {
            bfs_b();
        }

        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                int ck = map[i][j];

                if (ck == 1) {
                    a++;
                } else if (ck == 2) {
                    b++;
                } else if (ck == 3) {
                    c++;
                }

            }
        }

        System.out.println(a + " " + b + " " + c);

    }

    public static void bfs_a() {

        int row = queue0.poll();
        int col = queue1.poll();
        int c_time = queue2.poll();

        time[row][col] = c_time;

        for (int i = 0; i < 4; i++) {
            try {
                if (map[row + order_row[i]][col + order_col[i]] == 0) {
                    queue0.add(row + order_row[i]);
                    queue1.add(col + order_col[i]);
                    queue2.add(c_time + 1);
                    map[row + order_row[i]][col + order_col[i]] = 1;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void bfs_b() {

        int row = queue0.poll();
        int col = queue1.poll();
        int c_time = queue2.poll();



        for (int i = 0; i < 4; i++) {
            try {
                if (map[row + order_row[i]][col + order_col[i]] == 1 || map[row + order_row[i]][col + order_col[i]] == 0) {

                    if (time[row + order_row[i]][col + order_col[i]] >= c_time + 1) {
                        if (time[row + order_row[i]][col + order_col[i]] == c_time + 1) {
                            map[row + order_row[i]][col + order_col[i]] = 3;
                        } else {
                            queue0.add(row + order_row[i]);
                            queue1.add(col + order_col[i]);
                            queue2.add(c_time + 1);
                            map[row + order_row[i]][col + order_col[i]] = 2;
                        }
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}


/*
해결 못함
*/