package backjoon;

import java.io.*;
import java.util.*;

//N과 M (5)
//26052022

public class b26052022_02 {

    static int num;
    static int target;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        nums = new int[num];
        visited = new boolean[num];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        recursion(0, "");

    }

    static void recursion(int count, String s) {

        if (count == target) {
             System.out.println(s);
        }

        for (int i = 0; i < nums.length; i++) {

            if (!visited[i]) {
                String now = s + nums[i] + " ";
                visited[i] = true;
                recursion(count + 1, now);
                visited[i] = false;   
            }
        }
    }

}