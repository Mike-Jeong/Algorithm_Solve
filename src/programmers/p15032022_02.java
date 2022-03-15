package programmers;

//import java.util.*;

//쿼드압축 후 개수 세기
//15032022

public class p15032022_02 {

    public static void main(String[] args) throws Exception {

        Solution80 s = new Solution80();

        int[][] a = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

        System.out.println(s.solution(a));

    }
}

class Solution80 {

    int[] count_n = {0,0};
    public int[] solution(int[][] arr) {

        recursion(arr);

        if (count_n[0] == 0 && count_n[1] == 4) {
            return new int[]{0,1};
        }

        if (count_n[1] == 0 && count_n[0] == 4) {
            return new int[]{1,0};
        }
        

        return count_n;
    }

    public void recursion(int[][] arr) {

        if (arr.length == 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                   count_n[arr[i][j]]++;
                }
            }

            return;
        }


        for (int i = 0; i < arr.length; i += arr.length/2) {
            for (int j = 0; j < arr.length; j += arr.length/2) {

                int target = arr[i][j];
                Boolean check = true;
                int[][] next_arr = new int[arr.length/2][arr.length/2];
                int row = 0;
                for (int j2 = 0 + i; j2 < i + arr.length/2; j2++) {
                    int col = 0;
                    for (int k = 0 + j; k < j + arr.length/2; k++) {
                        
                        if (target != arr[j2][k]) {
                            check = false;
                        }

                        next_arr[row][col] = arr[j2][k];
                        col++;
                    }
                    row++;
                }

                if (!check) {
                    recursion(next_arr);
                } else{

                    count_n[target]++;

                }
            }
        }

    }
}