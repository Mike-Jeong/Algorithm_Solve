package programmers;

//import java.util.*;

//거리두기 확인하기
//11032022

public class p11032022 {
    public static void main(String[] args) throws Exception {

        Solution73 s = new Solution73();

        String[][] a = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" },
                { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" },
                { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

        System.out.println(s.solution(a));
    }
}

class Solution73 {

    char[][] waitingRoom = new char[5][5];
    boolean[][] visited;
    int check;

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        int room_n = 0;

        for (String[] strings : places) {

            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 5; j++) {
                    waitingRoom[i][j] = strings[i].charAt(j);
                }
            }

            check = 1;
            visited = new boolean[5][5];

            loop: for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer.length; j++) {

                    if (waitingRoom[i][j] == 'P') {
                        recursion(i, j, 0);
                    }

                    if (check == 0) {
                        break loop;
                    }

                }
            }

            answer[room_n] = check;
            room_n++;
        }

        return answer;
    }

    public void recursion(int row, int col, int move) {

        if (move == 2) {
            return;
        }

        visited[row][col] = true;

        int[] row_order = { -1, 0, 1, 0 };
        int[] col_order = { 0, -1, 0, 1 };

        for (int i = 0; i < 4; i++) {

            try {
                if (!visited[row + row_order[i]][col + col_order[i]]
                        && waitingRoom[row + row_order[i]][col + col_order[i]] == 'P') {

                    check = 0;
                    return;
                } else {
                    if (!visited[row + row_order[i]][col + col_order[i]]
                            && waitingRoom[row + row_order[i]][col + col_order[i]] == 'O') {
                        recursion(row + row_order[i], col + col_order[i], move + 1);
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

    }

}