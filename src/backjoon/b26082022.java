package backjoon;

import java.io.*;
import java.util.*;

//강의실 배정
//26082022

public class b26082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Lecture[] lecs = new Lecture[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lecs[i] = new Lecture(s, e);
        }

        Arrays.sort(lecs);

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(lecs[0].e);

        for (int i = 1; i < n; i++) {

            if (queue.peek() <= lecs[i].s) {
                queue.poll();
            }

            queue.add(lecs[i].e);
        }

        System.out.println(queue.size());

    }
}

class Lecture implements Comparable<Lecture> {

    int s;
    int e;

    public Lecture(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Lecture o) {

        if (o.s == s) {
            return e - o.e;
        } else {
            return s - o.s;
        }
    }
}
