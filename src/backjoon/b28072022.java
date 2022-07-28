package backjoon;

import java.io.*;
import java.util.*;

//인구 이동
//28072022

public class b28072022 {

    static int[][] map;
    static boolean[][] visited;
    static int l;
    static int r;
    static int day = 0;
    static int[] rowOrder = new int[] { -1, 0, 1, 0 };
    static int[] colOrder = new int[] { 0, -1, 0, 1 };

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {

            boolean change = false;

            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {

                        List<int[]> list = new ArrayList<>();

                        boolean ck = bfs(list, i, j);

                        if (ck) {
                            change = true;
                        }
                    }
                }
            }

            if (!change) {
                break;
            }

            day++;
        }

        System.out.println(day);

    }

    public static boolean bfs(List<int[]> list, int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col });

        int sum = 0;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (!visited[now[0]][now[1]]) {

                list.add(now);
                sum += map[now[0]][now[1]];
                visited[now[0]][now[1]] = true;

                for (int i = 0; i < 4; i++) {

                    try {

                        int cal = Math.abs(map[now[0]][now[1]] - map[now[0] + rowOrder[i]][now[1] + colOrder[i]]);
         
                        if (cal <= r && cal >= l) {
                            queue.add(new int[] { now[0] + rowOrder[i], now[1] + colOrder[i] });
                        }

                    } catch (Exception e) {
                        continue;
                    }

                }
            }
        }

        int s = list.size();

        if (s > 1) {

            for (int i = 0; i < s; i++) {

                int[] now = list.get(i);

                map[now[0]][now[1]] = sum / s;
            }

            return true;
        } else {
            return false;
        }
    }
}