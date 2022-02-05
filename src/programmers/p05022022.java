package programmers;

import java.util.*;

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

        int[] answer = new int[queries.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }

    public int rotate(int[] query){

        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        int row_starting = query[0] -1;
        int column_starting = query[1] -1;
        int row_ending = query[2] -1;
        int column_ending = query[3] -1;

        int past = 0;
        int current = 0;

        for (int i = column_starting; i <= column_ending ; i++) {
            
            treeSet.add(matrix[row_starting][i]);
            current = matrix[row_starting][i];
            matrix[row_starting][i] = past;
            past = current;

        }

        for (int i = row_starting + 1; i <= row_ending ; i++) {
            
            treeSet.add(matrix[i][column_ending]);
            current = matrix[i][column_ending];
            matrix[i][column_ending] = past;
            past = current;

        }

        for (int i = column_ending - 1; i >= column_starting ; i--) {
            
            treeSet.add(matrix[row_ending][i]);
            current = matrix[row_ending][i];
            matrix[row_ending][i] = past;
            past = current;

        }

        for (int i = row_ending - 1; i > row_starting ; i--) {
            
            treeSet.add(matrix[i][column_starting]);
            current = matrix[i][column_starting];
            matrix[i][column_starting] = past;
            past = current;

        }

        matrix[row_starting][column_starting] = past;

        return treeSet.first();
    }
}