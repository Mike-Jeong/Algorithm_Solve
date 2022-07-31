package backjoon;

import java.io.*;
import java.util.*;

//치킨 배달
//31072022

public class b31072022 {
	static int m;
	static int ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static boolean[] open; 
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new int[]{i, j});
				} else if (map[i][j] == 1) {
					house.add(new int[]{i, j});
				}
			}
		}
		open = new boolean[chicken.size()];

		recusrion(0,0);
		System.out.println(ans);
    }

	public static void recusrion(int start, int cnt){

		if (cnt == m) {
			int res = 0;
 
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i)[0] - chicken.get(j)[0])
                                + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
 
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
		}

		for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            recusrion(i + 1, cnt + 1);
            open[i] = false;
        }
	}
}