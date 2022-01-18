package programmers;

import java.util.*;

//두개 뽑아서 더하기
//18012022

public class p18012022_02 {
    public static void main(String[] args) throws Exception {
        Solution21 s = new Solution21();

        int[] a = {2,1,3,4,1};

        System.out.println(s.solution(a));
        
    }
}

class Solution21 {

    public int[] solution(int[] numbers) {
        
        Set<Integer> resultset = new HashSet<>();

        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                resultset.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[resultset.size()];
        int i = 0;

        for (Integer integer : resultset) {
            answer[i] = integer;
            i++;
        }

        Arrays.sort(answer);

        return answer;
    }
}