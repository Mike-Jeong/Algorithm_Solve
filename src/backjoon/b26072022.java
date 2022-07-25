package backjoon;

import java.io.*;
import java.util.*;

//적록색약
//26072022

public class b26072022 {

    public static int n;
    public static char[][] map;
    public static int[][] map2;
    public static boolean[][] visited;
    public static int R = 0;
    public static int G = 0;
    public static int B = 0;
    public static int Z = 0;
    public static int[] rowOrder = new int[] { -1, 0, 1, 0 };
    public static int[] colOrder = new int[] { 0, -1, 0, 1 };

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        map2 = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            for (int j = 0; j < map.length; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'B') {
                    map2[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R') {
                        R++;
                    } else if (map[i][j] == 'G') {
                        G++;
                    } else {
                        B++;
                    }
                    recursion(i, j, map[i][j]);
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (!visited[i][j] && map2[i][j] == 0) {
                    Z++;
                    recursion2(i, j, map2[i][j]);
                }
            }
        }

        System.out.println((R + G + B) + " " + (B + Z));

    }

    public static void recursion(int r, int c, char target) {

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            try {
                if (map[r + rowOrder[i]][c + colOrder[i]] == target && !visited[r + rowOrder[i]][c + colOrder[i]]) {
                    recursion(r + rowOrder[i], c + colOrder[i], target);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void recursion2(int r, int c, int target) {

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            try {
                if (map2[r + rowOrder[i]][c + colOrder[i]] == target && !visited[r + rowOrder[i]][c + colOrder[i]]) {
                    recursion2(r + rowOrder[i], c + colOrder[i], target);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
