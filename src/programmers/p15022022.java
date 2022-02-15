package programmers;

import java.util.*;

//소수찾기
//15022022

public class p15022022 {
    public static void main(String[] args) throws Exception {
        Solution48 s = new Solution48();

        int a = 10;
        //4

        System.out.println(s.solution(a));
    }
}

class Solution48 {

    public int solution(int n) {
        int answer = 0;
        int arr[] = new int[n+1];
        arr[0] = 0; 
        arr[1] = 0;
        
        for (int i = 2 ; i <= n; i++) { arr[i] = i; }
        
        for (int i = 2 ; i <= (int)Math.sqrt(n) ; i++) {

            if(arr[i] == 0) continue;

            for (int j = 2 * i ; j <= n; j+=i) {
                arr[j] = 0;
            }
        }

        for (int i = 0; i <= n ; i++ ) {
            if (arr[i] != 0) answer++;
        }

        return answer;
    }
}