package backjoon;

import java.io.*;
import java.util.*;

//센서
//06092022

public class b06092022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] sensor = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        int[] minResult = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            minResult[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(minResult);

        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            ans += minResult[i];
        }

        System.out.println(ans);
    }
}