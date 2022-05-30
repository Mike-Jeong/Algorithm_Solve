package backjoon;

import java.io.*;
import java.util.*;

//DFS와 BFS
//30052022

public class b30052022 {

    static boolean[][] edges;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        edges = new boolean[node + 1][node + 1];
        visited = new boolean[node + 1];
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            edges[v1][v2] = true;
            edges[v2][v1] = true;

        }

        dfs(start);
        System.out.print("\n");

        visited = new boolean[node + 1];

        queue.add(start);

        while (!queue.isEmpty()) {
            bfs();
        }



    }

    static void dfs(int node) {

        visited[node] = true;

        System.out.print(node + " ");

        for (int i = 1; i < visited.length; i++) {
            if (edges[node][i] && !visited[i]) {
                dfs(i);
            }
        }

    }

    static void bfs() {

        int current = queue.poll();

        if (!visited[current]) {
            visited[current] = true;

            System.out.print(current + " ");
    
            for (int i = 1; i < visited.length; i++) {
                if (edges[current][i] && !visited[i]) {
                   queue.add(i);
                }
            }
        }
    }

}
