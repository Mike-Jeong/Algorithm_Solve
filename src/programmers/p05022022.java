package programmers;

import java.util.*;

import apple.laf.JRSUIUtils.Tree;

//행렬 테두리 회전하기
//05022022

public class p05022022 {
    public static void main(String[] args) throws Exception {
        Solution37 s = new Solution37();

        int a = 6;
        int b = 6;
        int[][] c ={{2,2,5,4},{3,3,6,6},{5,1,6,3}}; 

        System.out.println(s.solution(a, b, c));
    }
}

class Solution37 {

    int[][] queries;
    int[][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {

        this.queries = queries;

        matrix = new int[rows][columns];

        int count = 1;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = count;
                count++;    
            }

        }



        int[] answer = new int[3];
        return answer;
    }

    public int rotate(int[] query){

        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        int column_starting

        for (int column_starting = query[1] - 1; column_starting <= query[3] - 1; column_starting++) {
            
        }

        for (int column_starting = query[1] - 1; column_starting <= query[3] - 1; column_starting++) {
            
        }

        for (int column_starting = query[1] - 1; column_starting <= query[3] - 1; column_starting++) {
            
        }

        for (int column_starting = query[1] - 1; column_starting <= query[3] - 1; column_starting++) {
            
        }

        return 0;
    }
}