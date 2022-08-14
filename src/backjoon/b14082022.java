package backjoon;

import java.io.*;
import java.util.*;

//배
//14082022

public class b14082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] crane = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> container = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            container.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(container, Collections.reverseOrder());

        if (crane[n - 1] < container.get(0)) {
            System.out.println("-1");
        } else {
            int time = 0;
            while (!container.isEmpty()) {
                int idx = 0;
                for (int i = n - 1; 0 <= i;) {
                    if (idx == container.size()) {
                        break;
                    } else if (crane[i] >= container.get(idx)) {
                        container.remove(idx);
                        i--;
                    } else {
                        idx++;
                    }
                }
                time++;
            }
            System.out.println(time);
        }
    }
}
