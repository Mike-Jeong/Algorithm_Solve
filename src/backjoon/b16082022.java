package backjoon;

import java.io.*;
import java.util.*;

//소수의 연속합
//16082022

public class b16082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n + 1];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i + i; j <= n; j += i) {
                prime[j] = true;
            }
        }

        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 0; i < prime.length; i++) {
            if (!prime[i]) {
                primeList.add(i);
            }
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int count = 0;

        while (true) {
            if (sum >= n) {
                sum -= primeList.get(start++);
            } else if (end == primeList.size()) {
                break;
            } else {
                sum += primeList.get(end++);
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}