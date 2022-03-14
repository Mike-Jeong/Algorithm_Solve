package programmers;

import java.util.*;

//게임 맵 최단거리
//14032022

public class p14032022 {

    public static void main(String[] args) throws Exception {

        Solution78 s = new Solution78();

        int[][] a = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };

        System.out.println(s.solution(a));

    }
}

class Solution78 {

    public int solution(int[][] maps) {

        int enemy_row = maps.length - 1;
        int enemy_col = maps[0].length - 1;

        int[][] visited = new int[enemy_row + 1][enemy_col + 1];
        int[] order_row = { -1, 0, 1, 0 };
        int[] order_col = { 0, -1, 0, 1 };

        Queue<int[]> queue = new LinkedList<>();

        int[] start = {0,0};
        visited[0][0] = 1;

        queue.add(start);

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            if (current[0] == enemy_row && current[1] == enemy_col) {
                return visited[current[0]][current[1]];
            }

            for (int i = 0; i < 4; i++) {
                try {
                    if (maps[current[0] + order_row[i]][current[1] + order_col[i]] == 1
                            && visited[current[0] + order_row[i]][current[1] + order_col[i]] == 0) {
                        queue.add(new int[] {current[0] + order_row[i],current[1] + order_col[i]});
                        visited[current[0] + order_row[i]][current[1] + order_col[i]] = visited[current[0]][current[1]] + 1;
                    }
                } catch (Exception e) {
                    continue;
                }
    
            }
        }
        return -1;
    }
}


/*
class Solution78 {

    boolean[][] visited;
    int[] order_row = { -1, 0, 1, 0 };
    int[] order_col = { 0, -1, 0, 1 };
    int enemy_row;
    int enemy_col;
    int answer = -1;
    int[][] maps;

    public int solution(int[][] maps) {

        this.maps = maps;

        enemy_row = maps.length - 1;
        enemy_col = maps[0].length - 1;

        visited = new boolean[enemy_row + 1][enemy_col + 1];

        recursion(0, 0, 0);

        return answer;
    }

    public void recursion(int row, int col, int count) {

        count++;
        visited[row][col] = true;

        if (row == enemy_row && col == enemy_col) {

            if (answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
            visited[row][col] = false;
            return;
        }

        for (int i = 0; i < 4; i++) {

            try {
                if (maps[row + order_row[i]][col + order_col[i]] == 1
                        && !visited[row + order_row[i]][col + order_col[i]]) {
                    recursion(row + order_row[i], col + order_col[i], count);
                }
            } catch (Exception e) {
                continue;
            }

        }

        visited[row][col] = false;
    }
}

// 시간초과..............
//DFS 가 아닌 bfs 로 풀어야함

*/