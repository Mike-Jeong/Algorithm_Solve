package programmers;

import java.util.*;

import backjoon.b2588;

//배열 관련 알고리즘 풀이(스터디 그룹원 질문 풀이)
//08022022
//2

public class p08022022_02 {
    public static void main(String[] args) throws Exception {
        int[][] array_0 = { { 1, 2, 3, 4, 5, 6 }, { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 },
                { 31, 32, 33, 34, 35, 36 }, { 41, 42, 43, 44, 45, 46 } };

        System.out.println("------------------------------");

        Lab6 aa = new Lab6();

        int[][] a = aa.rotate90Degrees(array_0);

        aa.printArray(a);

        int[][] b = aa.horizotalMirror(array_0);

        aa.printArray(b);

        int[][] c = aa.verticalMirror(array_0);

        aa.printArray(c);

        int[][] d = aa.diagonalShift(array_0);

        aa.printArray(d);

        int[][] e = aa.fillArray_diagonal(5,4);

        aa.printArray(e);

    }
}

class Lab6 {

    public int[][] rotate90Degrees(int[][] arr) {

        int[][] transformedArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < transformedArr.length; i++) {
            for (int j = 0; j < transformedArr[0].length; j++) {
                transformedArr[i][j] = arr[arr.length - 1 - j][i];
            }
        }

        return transformedArr;
    }

    public int[][] horizotalMirror(int[][] arr) {

        int[][] transformedArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transformedArr[i][j] = arr[arr.length - 1 - i][j];
            }
        }

        return transformedArr;
    }

    public int[][] verticalMirror(int[][] arr) {

        int[][] transformedArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                transformedArr[i][j] = arr[i][arr[0].length - 1 - j];
            }
        }

        return transformedArr;
    }

    public int[][] diagonalShift(int[][] arr) {

        int[][] transformedArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < transformedArr.length; i++) {
            for (int j = 0; j < transformedArr[0].length; j++) {
                if (i == 0 && j == 0) {
                    transformedArr[i][j] = arr[arr.length - 1][arr[0].length - 1];
                }

                else if (i == 0) {
                    transformedArr[i][j] = arr[arr.length - 1][j - 1];
                }

                else if (j == 0) {
                    transformedArr[i][j] = arr[i - 1][arr[0].length - 1];
                }

                else{transformedArr[i][j] = arr[i - 1][j - 1];}
            }
        }

        return transformedArr;
    }

    public int[][] fillArray_diagonal(int a, int b)
    {

        int[][] array = new int[a][b];
        int count = 0;
        
        for (int cycle = 0; cycle <= (b * 2) - 1; cycle++) {
            for (int i = 0; i < a; i++) {
                
                int j = cycle - i;

                if (j>=0 && j < b) {
                    array[i][j] = count;
                    count++;
                }

            }
        }
        

        return array;
    }

    public void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                System.out.printf("%3d", arr[i][j]);
            }

            System.out.println();

        }

        System.out.println("**********************************");
    }

}
