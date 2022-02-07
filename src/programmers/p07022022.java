package programmers;

import java.util.*;

//카카오 프렌즈 컬러링북
//07022022

public class p07022022 {
    public static void main(String[] args) throws Exception {
        Solution39 s = new Solution39();

        int a = 6;
        int b = 4;
        int[][] c = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 }, { 0, 0, 0, 3 } };

        System.out.println(s.solution(a, b, c));
    }
}

class Solution39 {
    int numberOfArea;
    int maxSizeOfOneArea;
    boolean[][] visited;
    int[][] picture;
    int maxrow;
    int maxcolumns;
    int sizeofarea;
    int[] caculate = { 1, -1 };

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        this.picture = picture;
        maxrow = m - 1;
        maxcolumns = n - 1;

        for (boolean[] ck : visited) {
            Arrays.fill(ck, false);
        }

        for (int i = 0; i < picture.length; i++) {
            
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {

                    numberOfArea++;
                    sizeofarea = 0;
                    dfs(i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeofarea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    void dfs(int row_index, int col_index) {

        if (visited[row_index][col_index]) {
            return;
        }

        sizeofarea++;
        visited[row_index][col_index] = true;

        for (int i = 0; i < 2; i++) {
            try {
                if (picture[row_index][col_index] == picture[row_index + caculate[i]][col_index]) {
                    dfs(row_index + caculate[i], col_index);
                }       
            } catch (Exception e) {
                continue;
            }
        }

        for (int i = 0; i < 2; i++) {
            try {
                if (picture[row_index][col_index] == picture[row_index][col_index + caculate[i]]) {
                    dfs(row_index, col_index + caculate[i]);
                }       
            } catch (Exception e) {
                continue;
            }
        }

    }
}