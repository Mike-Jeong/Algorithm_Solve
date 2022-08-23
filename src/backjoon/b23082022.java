package backjoon;

import java.io.*;
import java.util.*;

//미친 로봇
//23082022

public class b23082022 {

    static boolean[][] visited;
    static double[] percents;
    static int[] rowOrder = new int[] { 0, 0, -1, 1 };
    static int[] colOrder = new int[] { 1, -1, 0, 0 };
    static int n;
    static double ans = 0.0;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        percents = new double[4];

        for (int i = 0; i < 4; i++) {
            percents[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited = new boolean[30][30];

        recursion(15, 15, 0, 1.0);

        System.out.println(ans);

    }

    public static void recursion(int row, int col, int count, double percent) {

        if (count == n) {
            ans += percent;
            return;
        }
        
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + rowOrder[i];
            int nextCol = col + colOrder[i];

            try {
                if (!visited[nextRow][nextCol]) {
                    recursion(nextRow, nextCol, count + 1, percent * percents[i]);
                }
            } catch (Exception e) {
                continue;
            }
        }
        visited[row][col] = false;
    }
}