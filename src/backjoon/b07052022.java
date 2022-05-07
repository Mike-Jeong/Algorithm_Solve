package backjoon;

import java.io.*;
import java.util.*;

//바이러스
//07052022

public class b07052022 {

    static boolean[] visited;
    static int count = -1;
    static Map<Integer, ArrayList<Integer>> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int cities = Integer.valueOf(st.nextToken());
        visited = new boolean[cities + 1];

        st = new StringTokenizer(in.readLine());

        int n_edge = Integer.valueOf(st.nextToken());

        for (int i = 0; i < n_edge; i++) {
            st = new StringTokenizer(in.readLine());

            int city_a = Integer.valueOf(st.nextToken());
            int city_b = Integer.valueOf(st.nextToken());

            if (!nodes.containsKey(city_a)) {
                ArrayList<Integer> edges = new ArrayList<>();
                nodes.put(city_a, edges);
            }

            nodes.get(city_a).add(city_b);

            if (!nodes.containsKey(city_b)) {
                ArrayList<Integer> edges = new ArrayList<>();
                nodes.put(city_b, edges);
            }

            nodes.get(city_b).add(city_a);
        }

        dfs(1);
        System.out.println(count);

    }

    static void dfs(int city) {

        visited[city] = true;
        count++;

        if (nodes.containsKey(city)) {

            ArrayList<Integer> current = nodes.get(city);

            if (current.size() > 0) {
                for (int i = 0; i < current.size(); i++) {
                    if (!visited[current.get(i)]) {
                        dfs(current.get(i));
                    }
                }
            }
        }
    }

}
