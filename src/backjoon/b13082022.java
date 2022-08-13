package backjoon;

import java.io.*;
import java.util.*;

//CCW
//13082022

public class b13082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] points = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = ccw(points);

        if (result == 0) {
            System.out.println(0);
        } else{
            int ans = result > 0 ? 1 : -1;
            System.out.println(ans);
        }

        
    }

    static int ccw(int[][] points) {
        return (points[1][0] - points[0][0])*(points[2][1] - points[0][1]) - (points[2][0] - points[0][0])*(points[1][1] - points[0][1]);
    }
    //CCW는 Counter Clockwise의 약자로써, 평면 위에 놓여진 세 점의 방향관계를 구할 수 있는 알고리즘입니다.
    //먼저 한 줄로 요약하자면, CCW는 점 A, B,C를 순서대로 봤을때 반시계방향으로 놓여 있으면 양수를, 시계방향이면 음수를, 평행하게 놓여있으면 0을 반환하게 됩니다. 
    //출처 : https://degurii.tistory.com/47
}
