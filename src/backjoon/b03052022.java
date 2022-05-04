package backjoon;

import java.io.*;
import java.util.*;

//ATM
//03052022

public class b03052022 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(in.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
            ans += arr[i];
        }

        System.out.println(ans);

    }

}
