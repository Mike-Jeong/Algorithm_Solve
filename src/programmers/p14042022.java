package programmers;

import java.util.*;

//ㄷ자 모양 채우기
//4

public class p14042022 {

    public static void main(String[] args) throws Exception {

        Solution103 s = new Solution103();

        int a = 4;
        int b = 1;
        int c = 3;

        System.out.println(s.solution(a, b, c));

    }
}

class Solution103 {

    int[][] board;
    int count = 1;
    int[] row_order = { 0, 0, 1, 1 };
    int[] col_order = { 0, -1, -1, 0 };
    int target_r;
    int target_c;

    public int solution(int n, int i, int j) {

        board = new int[n][n];

        target_r = i;
        target_c = j;

        fill_board(n, 0, n - 1);

        int answer = board[i][j];
        return answer;
    }

    public boolean fill_board(int n, int x, int y) {

        if (n == 2) {
            for (int i = 0; i < 4; i++) {

                board[x + row_order[i]][y + col_order[i]] = count;

                if ((x + row_order[i]) == target_r && (y + col_order[i]) == target_c) {
                    return true;
                }
                count++;
            }
            return false;

        } else {

            if (fill_board(n / 2, x + 0, y + 0)) {
                return true;
            } else if (fill_board(n / 2, x + 0, y + (-n / 2))) {
                return true;
            } else if (fill_board(n / 2, x + (n / 2), y + (-n / 2))) {
                return true;
            } else if (fill_board(n / 2, x + (n / 2), y + 0)) {
                return true;
            }
            return false;
        }
    }
}// 효율성이 안나옴.....


/*
class Solution {
    int[][] board;
    int count = 1;
    int[] row_order = { 0, 0, 1, 1 };
    int[] col_order = { 0, -1, -1, 0 };

    public int solution(int n, int i, int j) {

        board = new int[n][n];

        fill_board(n, 0, n - 1);

        int answer = board[i][j];
        return answer;
    }

    public void fill_board(int n, int x, int y) {

        if (n == 2) {
            for (int i = 0; i < 4; i++) {
                board[x + row_order[i]][y + col_order[i]] = count;
                count++;
            }
            return;
        }

        fill_board(n / 2, x + 0, y + 0);
        fill_board(n / 2, x + 0, y + (-n / 2));
        fill_board(n / 2, x + (n / 2), y + (-n / 2));
        fill_board(n / 2, x + (n / 2), y + 0);

    }
}//4번 다른 답변
*/

/*1번 소수 찾기
class Solution {
    public int solution(int n) {
       int N = 100;

       boolean check[] = new boolean[N + 1];

       for (int i = 2; i <= Math.sqrt(N); i++) {
           for (int j = i + i; j <= N; j += i) {
               check[j] = true;
           }
       }

       int ans = 0;

       for (int i = 2; i < n; i++) {
           if(!check[i]) {
               ans++;
           }
       }

       return ans;
   }
}*/

/*2번 순위 구분이 없는 당첨자를 뽑는 경우의 수
import java.util.*;

class Solution {
     public int solution(String[] names) {
        Set<String> a = new HashSet<>();

        for (String string : names) {
            a.add(string);
        }

        int s = a.size();
        int answer = ((s) * (s - 1) * (s - 2) * (s - 3)) / 24;

        return answer;
    }
}
*/

/*3번 맥주잔을 높이 N까지 Nx2의 직사각형 형태로 쌓아 올리는 방법의 수를 구하시오.
class Solution {
    public int solution(int n) {

        if (n == 1) {
            return 1;
        }
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        
        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num;
        }
        
        return arr[n-1];
    }
}
 */


 /*5번 이 때, 학생과 감독관을 교실에 배정하는 모든 경우의 수를 구하시오.
 class Solution {
    int capa = 0;
    int[] capacity;
    int[] room;
    int stu;
    int tea;
    long answer = 0;

    public long solution(int N, int M, int K, int[] capacity) {

        for (int i : capacity) {
            capa += i;
        }

        this.capacity = capacity;
        room = new int[M];
        stu = N;
        tea = K;

        recursion(0, 0);

        return answer;
    }

    public void recursion(int index, int count) {

        if (index == room.length) {
            if (count == stu) {
                long per = 1;
                
                for (int i = 0; i < room.length; i++) {
                    if (room[i] != 0) {
                        per *= (mul(count, (count - room[i])) / mul(room[i], 0));
                        
                    }
                    count -= room[i];
                }
                per *= (mul(tea, (tea - room.length)));

                answer += per;
            }

            return;
        }

        for (int i = 0; i <= capacity[index]; i++) {
            room[index] = i;
            recursion(index + 1, count + i);
        }
    }

    public long mul(int num, int end) {
        long ans = 1;
        for (int i = num; i > end; i--) {
            ans *= i;
        }

        return ans;
    }
}
 */

