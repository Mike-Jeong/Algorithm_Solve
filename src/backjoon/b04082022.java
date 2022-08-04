package backjoon;

import java.io.*;
import java.util.*;

//ABCDE
//04082022

public class b04082022 {

	static int n;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean[] visited;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
        }

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
        }
        System.out.println(0);

	}

	public static void dfs(int x, int len) {
        if(len == 4) {
            System.out.println(1);
            System.exit(0);
        }
        
        visited[x] = true;
		ArrayList<Integer> now = map.get(x);
        for(int i = 0; i < now.size(); i++) {
            int temp = now.get(i);
            if(visited[temp] == false) {
                visited[temp] = true;
                dfs(temp, len + 1);
                visited[temp] = false;
            }
        }
    }
}

