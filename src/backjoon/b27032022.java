package backjoon;

import java.io.*;
import java.util.*;

//빙산
//27032022

public class b27032022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] ice = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution s = new Solution();

        s.solution(ice);

    }
}

class Solution {

    int[][] ice;
    boolean[][] visited;

    public int solution(int[][] ice) {

        this.ice = ice;

        visited = new boolean[ice.length][ice[0].length];
        for (int i = 0; i < ice.length; i++) {
            for (int j = 0; j < ice[0].length; j++) {

            }
        }

        return 0;
    }
}