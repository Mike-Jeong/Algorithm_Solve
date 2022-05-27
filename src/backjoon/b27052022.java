package backjoon;

import java.io.*;
import java.util.*;

//모든 순열
//27052022

public class b27052022 {

    static int num;
    static Queue<Integer> queue = new LinkedList<>();
    static PriorityQueue<String> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            queue.add(i + 1);
        }
        
        recursion("", num);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }

    static void recursion(String s, int count) {

        if (queue.isEmpty()) {
           priorityQueue.add(s);
            return;
        }

        for (int i = 0; i < count; i++) {
            int current = queue.poll();
            String now = s + current + " ";
            recursion(now, count - 1);
            queue.add(current);
        }
       
    }

}