package backjoon;

import java.io.*;
import java.util.*;

//스타트링크
//24072022

public class b24072022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[f + 1];

        int ans = bfs(f, s, g, u, d, arr);

        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }

    public static int bfs(int f, int s, int e, int u, int d, int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        arr[s] = 1;
 
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == e) {
                return arr[current] - 1;
            }
            if (current + u <= f) {
                if (arr[current + u] == 0) {
                    arr[current + u] = arr[current] + 1;
                    q.add(current + u);
                }
 
            }
            if (current - d > 0) {
                if (arr[current - d] == 0) {
                    arr[current - d] = arr[current] + 1;
                    q.add(current - d);
                }
            }
 
        }
        return -1;
    }
}
