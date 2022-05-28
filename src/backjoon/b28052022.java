package backjoon;

import java.io.*;
import java.util.*;

//어린왕자
//28052022

public class b28052022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int n_p = Integer.parseInt(st.nextToken());

            int count = 0;

            for (int j = 0; j < n_p; j++) {

                st = new StringTokenizer(br.readLine());

                int now_x = Integer.parseInt(st.nextToken());
                int now_y = Integer.parseInt(st.nextToken());
                int now_r = Integer.parseInt(st.nextToken());

                boolean start_now = ((start_x - now_x) * (start_x - now_x)
                        + (start_y - now_y) * (start_y - now_y) > now_r * now_r);

                boolean end_now = ((end_x - now_x) * (end_x - now_x)
                        + (end_y - now_y) * (end_y - now_y) > now_r * now_r);

                if (start_now && end_now) {
                    continue;
                }

                if (end_now || start_now) {
                    count++;
                }

            }

            System.out.println(count);

        }

    }

}