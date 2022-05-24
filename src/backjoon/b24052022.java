package backjoon;

import java.io.*;
import java.util.*;

//치킨 TOP N
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

        System.out.println(count0);
        System.out.println(count1);

    }

    static void recursion() {

        if (condition) {
            
        }

    }
}