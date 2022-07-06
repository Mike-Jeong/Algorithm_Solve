package backjoon;

import java.io.*;
import java.util.*;

//숨바꼭질 3
//06072022

public class b06072022 {

	static int min = Integer.MAX_VALUE;
    static int n, m;
    static boolean[] visited;
    static int max = 100000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[max + 1];
        bfs();
        System.out.println(min);

		
	}

	public static void bfs() {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == m) min = Math.min(min, node.time);
            
            if(node.x * 2 <= max && visited[node.x * 2] == false) q.offer(new Node(node.x * 2, node.time));
            if(node.x + 1 <= max && visited[node.x + 1] == false) q.offer(new Node(node.x + 1, node.time + 1));
            if(node.x - 1 >= 0 && visited[node.x - 1] == false) q.offer(new Node(node.x - 1, node.time + 1));
        }
    }

	public static class Node {
        int x;
        int time;
        
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}

