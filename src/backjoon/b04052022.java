package backjoon;

import java.io.*;
import java.util.*;

//1, 2, 3 더하기
//04052022

public class b04052022 {

    static int[] nums = { 1, 2, 3 };
    static int count;
    static int target;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            count = 0;
            target = in.nextInt();
            recursion(0);
            System.out.println(count);
        }

        in.close();

    }

    public static void recursion(int sum) {
        
        if (sum >= target) {
            if (sum == target) {
                count++;
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            sum += nums[i];
            recursion(sum);
            sum -= nums[i];
        }
    }

}
