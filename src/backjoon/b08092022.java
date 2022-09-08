package backjoon;

import java.io.*;
import java.util.*;

//벽장문의 이동
//08092022

public class b08092022 {

    static int n;
    static int m;
    static int ans = 987654321;
    static int nums[];

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int o1 = Integer.parseInt(st.nextToken());
        int o2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }

        recursion(o1, o2, 0, 0);

        System.out.println(ans);

    }

    public static void recursion(int o1, int o2, int idx, int cnt) {
        if (idx == m) {
            ans = Math.min(ans, cnt);
            return;
        }
        int tmp_a = Math.abs(o1 - nums[idx]);
        int tmp_b = Math.abs(o2 - nums[idx]);

        recursion(nums[idx], o2, idx + 1, cnt + tmp_a);
        recursion(o1, nums[idx], idx + 1, cnt + tmp_b);
    }
}