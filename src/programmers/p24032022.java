package programmers;

import java.util.*;

//피로도
//24032022

public class p24032022 {

    public static void main(String[] args) throws Exception {

        Solution89 s = new Solution89();

        int a = 80;
        int[][] b = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

        System.out.println(s.solution(a, b));

    }
}

class Solution89 {

    LinkedList<int[]> list = new LinkedList<>();
    int c = 0;

    public int solution(int k, int[][] dungeons) {

        for (int[] is : dungeons) {
            list.add(is);
        }

        recursion(k, 0);

        return c;
    }

    public void recursion(int k, int count) {

        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                int[] now = list.poll(); 
                if (now[0] <= k) {
                    recursion(k-now[1], count + 1);
                }
                list.add(now);
            }
        }

        c = Math.max(c, count);
    }
}