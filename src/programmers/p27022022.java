package programmers;

import java.util.*;

//H-Index
//27022022

public class p27022022 {
    public static void main(String[] args) throws Exception {

        Solution60 s = new Solution60();

        int[] a = {3, 0, 6, 1, 5};

        System.out.println(s.solution(a));
    }
}

class Solution60 {

    public int solution(int[] citations) {
        Integer[] intArray = new Integer[citations.length];

        for(int i = 0; i < citations.length; i++)
            intArray[i] = citations[i];

        Arrays.sort(intArray, Collections.reverseOrder());

        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] <= i+1)
                return i;
        }

        return intArray.length;
    }
}//https://programmers.co.kr/questions/25087