package backjoon;

import java.io.*;
import java.util.*;

//색종이 만들기
//24052022

public class b24052022 {

    static int num;
    static int[][] board;
    static int count0 = 0;
    static int count1 = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());

        board = new int[num][num];

        for (int i = 0; i < board.length; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, num);

        System.out.println(count0);
        System.out.println(count1);

    }

    static void recursion(int x, int y, int length) {

        if (length == 1) {

            if (board[x][y] == 1) {
                count1++;
            } else {
                count0++;
            }
            return;
        }

        int target = board[x][y];
        boolean eq = true;

        loop:

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[x + i][y + j] != target) {
                    eq = false;
                    break loop;
                }
            }
        }

        if (eq) {
            if (target == 1) {
                count1++;
            } else {
                count0++;
            }
        } else {

            recursion(x, y, length / 2);
            recursion(x, y + (length / 2), length / 2);
            recursion(x + (length / 2), y, length / 2);
            recursion(x + (length / 2), y + (length / 2), length / 2);

        }

    }
}