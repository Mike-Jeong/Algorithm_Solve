package backjoon;

import java.io.*;
import java.util.*;

//이진 검색 트리
//04092022

public class b04092022 {

    static ArrayList<Integer> tree;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new ArrayList<Integer>();
        
        while (true) {
            String n = br.readLine();
            if (n == null || n.equals("")) {
                break;
            }

            tree.add(Integer.parseInt(n));
        }

        postOrder(0, tree.size() - 1);

    }

    public static void postOrder(int idx, int end) {
        if (idx > end) {
            return;
        }

        int mid = idx + 1;

        while (mid <= end && tree.get(mid) < tree.get(idx)) {
            mid++;
        }

        postOrder(idx + 1, mid - 1);
        postOrder(mid, end);

        System.out.println(tree.get(idx));
    }

}