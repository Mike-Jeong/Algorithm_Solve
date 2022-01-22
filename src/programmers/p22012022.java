package programmers;

import java.util.*;

//더 맵게
//22012022

public class p22012022 {
    public static void main(String[] args) throws Exception {
        Solution23 s = new Solution23();

        int[] a = {1, 2, 3};
        int b = 11;

        System.out.println(s.solution(a,b));

    }
}

class Solution23 {

    int K;
    int S = 0;

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (Integer integer : scoville) {
            minHeap.add(integer);
        }
        this.K = K;
        return caculate(minHeap);
    }

    public int caculate(PriorityQueue<Integer> scoville) {
        
        if (scoville.peek() >= K) {
            return S;
        } else {

            if (scoville.size() <= 1 ) {
                return -1;
            }
            int a = scoville.poll();
            int b = scoville.poll();
            int cal = a + (b * 2);
            scoville.add(cal);
            S++;
            return caculate(scoville);
        }
    }
}