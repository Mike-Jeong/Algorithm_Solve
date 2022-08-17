package backjoon;

import java.io.*;
import java.util.*;

//아기 상어
//17082022

public class b17082022 {

    static int[][] map;
    static int[] sharkLoc = new int[2];
    static int sharkSize = 2;
    static int[] rowOrder = new int[] { -1, 0, 1, 0 };
    static int[] colOrder = new int[] { 0, -1, 0, 1 };
    static int count = 0;
    static int time = 0;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {

                int value = Integer.parseInt(st.nextToken());

                if (value == 9) {
                    sharkLoc[0] = i;
                    sharkLoc[1] = j;
                    map[i][j] = 0;
                } else {
                    map[i][j] = value;
                }
            }
        }

        while (true) {
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[n][n];

            que.add(new int[]{sharkLoc[0], sharkLoc[1], 0}); 
            visit[sharkLoc[0]][sharkLoc[1]] = true;

            boolean ck = false; 

            while (!que.isEmpty()) {
                int[] cur = que.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < sharkSize) { 
                    map[cur[0]][cur[1]] = 0;
                    count++; 
                    time += cur[2];
                    ck = true; 
                    sharkLoc[0] = cur[0];
                    sharkLoc[1] = cur[1];
                    break;
                }

                for (int k = 0; k < 4; k++) {

                    try {
                        if (map[cur[0] + rowOrder[k]][cur[1] + colOrder[k]] <= sharkSize && !visit[cur[0] + rowOrder[k]][cur[1] + colOrder[k]]) {
                            que.add(new int[]{cur[0] + rowOrder[k], cur[1] + colOrder[k], cur[2] + 1});
                            visit[cur[0] + rowOrder[k]][cur[1] + colOrder[k]] = true;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }

            if (!ck) 
                break;

            if (sharkSize == count) { 
                sharkSize++;
                count = 0;
            }
        }

        System.out.println(time);

    }

}