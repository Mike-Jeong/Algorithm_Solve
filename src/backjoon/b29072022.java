package backjoon;

import java.io.*;
import java.util.*;

//탑
//29072022

public class b29072022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Stack<int[]> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= v) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] { i, v });
        }

    }
}