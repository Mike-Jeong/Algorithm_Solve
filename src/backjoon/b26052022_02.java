package backjoon;

import java.io.*;
import java.util.*;

//N과 M (5)
//26052022

public class b26052022_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[num];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());    
        }

       
    }

}