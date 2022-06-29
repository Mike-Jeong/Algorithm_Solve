package backjoon;

import java.io.*;
import java.util.*;

//게임
//29062022

public class b29062022 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = getPercent(x, y);

        int ans = -1;
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getPercent(x + mid, y + mid) != z) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
        sc.close();

    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}