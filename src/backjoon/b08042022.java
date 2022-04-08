package backjoon;

import java.util.*;

public class b08042022 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = 1000000;

        boolean check[] = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            check[i] = true;
        }

        // 에라토스테네스의 체 //소수찾기
        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = i + i; j <= N; j += i) {
                check[j] = false;
            }
        }

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            int tmp = n / 2;

            for (int j = 2; j <= tmp; j++) {
                if (check[j] && check[n - j]) {
                    System.out.println(n + " = " + j + " + " + (n - j));
                    break;
                }
            }
        }

        sc.close();
    }
}
