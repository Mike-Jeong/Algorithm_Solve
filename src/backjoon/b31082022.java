package backjoon;

import java.io.*;
import java.util.*;

//동전 바꿔주기
//31082022

public class b31082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        Queue<Coin> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            queue.add(new Coin(value, amount));
        }

        int[][] dp = new int[k + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i < k + 1; i++) {

            Coin coin = queue.poll();

            for (int j = 0; j <= coin.amount; j++) {

                for (int n = 0; n <= target; n++) {

                    int pos = n + coin.value * j;

                    if (pos > target) {
                        break;
                    }

                    dp[i][pos] += dp[i - 1][n];
                }
            }
        }
        System.out.println(dp[k][target]);

    }

}

class Coin implements Comparable<Coin> {
    int value;
    int amount;

    public Coin(int value, int amount) {
        this.amount = amount;
        this.value = value;
    }

    @Override
    public int compareTo(Coin o) {
        return this.value - o.value;
    }

}