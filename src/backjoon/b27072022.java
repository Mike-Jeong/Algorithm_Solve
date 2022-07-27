package backjoon;

import java.io.*;
import java.util.*;

//공유기 설치
//27072022

public class b27072022 {

    public static int[] house;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int lo = 1;
        int hi = house[n - 1] - house[0] + 1;

        while (lo < hi) {

            int mid = (hi + lo) / 2;

            if (canInstall(mid) < m) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }

    public static int canInstall(int distance) {

        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < house.length; i++) {

            int locate = house[i];

            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }

}