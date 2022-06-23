package programmers;

import java.util.*;

//?
//23062022

public class p23062022 {

    public static void main(String[] args) throws Exception {

        Solution113 s = new Solution113();

        // int a = 3;
        // int b = 99;

        int a = 15;

        // String a = "zerobase";
        // String[] b = { "zer", "rob", "ze", "base" };

        // int a = 5000;
        // int[] b = { 1400, 1200, 80, 45, 22, 10 };

        // int a = 6;
        // int b = 6;
        // int[][] c = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {1,
        // 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}, {1, 1, 1, 0, 0, 0}};

        System.out.println(s.solution(a));

        //System.out.println(a.replace(b[2], "").replace(b[2], "").replace(b[2], ""));

    }
}

class Solution113 {

    int len;
    int target;

    ArrayList<Integer> arrayList = new ArrayList<>();

    public int[] solution(int n) {

        len = String.valueOf(n).length();
        target = n;

       for (int i = 1; i < 10; i++) {

            if (n >= i) {
                recursion(i, 1);
            }
        }

        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {

            answer[i] = arrayList.get(i);

        }
        return answer;
    }

    public void recursion(int num, int count) {

        arrayList.add(num);

        if (len == count) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            int n = num * 10;
            n += i;
            if (n <= target) {
                recursion(n, count + 1);
            }
        }
    }
}
