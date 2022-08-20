package backjoon;

import java.io.*;
import java.util.*;

//개똥벌레
//20082022

public class b20082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int [] bottom = new int[h+1];
        int [] top = new int[h+1];

        for(int i = 0; i < n; ++i)
        {
            int height = Integer.parseInt(br.readLine());

            if(i % 2 == 0) bottom[height]++;
            else top[height]++;
        }

        for(int i = h-1; i > 0; --i)
        {
            bottom[i] += bottom[i+1];
            top[i] += top[i+1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 1; i <= h; ++i)
        {
            int total = bottom[i] + top[h-i+1];

            if(min > total)
            {
                min = total;
                count = 1;
            }
            else if(min == total) count++;
        }
        System.out.println(min + " " + count);
    }
}