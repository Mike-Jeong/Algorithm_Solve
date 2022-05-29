package backjoon;

import java.io.*;
import java.util.*;

//패션왕 신해빈
//29052022

public class b29052022 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String name = sc.next(), type = sc.next();
                if (name.equals("")) {
                    
                }
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int ans = 1;
            for (int val : map.values())
                ans *= val + 1;
            System.out.println(ans - 1);
        }

        sc.close();
    }
}
          