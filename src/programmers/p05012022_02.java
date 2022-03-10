package programmers;

import java.util.*;

//없는 숫자 더하기
//05012022

public class p05012022_02 {
    public static void main(String[] args) throws Exception {
        Solution06 s = new Solution06();

        int[] a = {1,2,3,4,6,7,8,0}; 

        System.out.println(s.solution(a));
    }
}

class Solution06 {

    public int solution(int[] numbers) {

        HashSet<Integer> numset = new HashSet<Integer>();

        numset.add(0);
        numset.add(1);
        numset.add(2);
        numset.add(3);
        numset.add(4);
        numset.add(5);
        numset.add(6);
        numset.add(7);
        numset.add(8);
        numset.add(9);

        int answer = 0;

        for (int num : numbers) {
            numset.remove(num);
        }

        Iterator<Integer> iter = numset.iterator();

        while(iter.hasNext()) 
        { answer += iter.next(); }

        return answer;
    }
}

/*
class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}
// 엌ㅋㅋㅋㅋ...... 빼는 방법도 있구나........
*/