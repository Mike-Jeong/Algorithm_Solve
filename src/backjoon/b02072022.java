package backjoon;

import java.io.*;
import java.util.*;

//최소비용 구하기
//02072022

public class b02072022 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			Arrays.fill(arr[i], -1); // 가중치 0이 있을수도 있으니 -1로 초기화 
		}

		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int d = sc.nextInt();
			int c = sc.nextInt();

			// 시작 정점과 도착 정점이 같은데 비용이 다른 값이 들어올 수 있기 때문에 예외 처리 
			if(arr[a][d] == -1) 
				arr[a][d] = c;
			else if(arr[a][d] > c) 
				arr[a][d] = c;
		}

		int start = sc.nextInt();
		int end = sc.nextInt();

		boolean[] check = new boolean[N+1]; // 정점이 집합 S에 속하는지 아닌지를 판별할 배열 

		int[] distance = new int[N+1]; // 최단 거리를 담을 배열 
		Arrays.fill(distance, Integer.MAX_VALUE-1); // 무한대로 초기화 

		distance[start] = 0;

		for(int i = 0; i < N-1; i++) { // 시작점을 넣고 시작하기 때문에 N-1만큼만 반복 
			int min = Integer.MAX_VALUE;
			int index = -1;

			// 집합 S에 속하지 않는 가장 최단 거리를 갖는 정점 선택함 
			for(int j = 1; j < N+1; j++) { 
				if(!check[j] && distance[j] < min) {
					min = distance[j]; // 최단 거리 
					index = j; // 최단 거리를 갖는 정점의 index 
				}
			}

			check[index] = true;

			// S에 속하지 않는다면 더 작은 값을 갖는 거리로 distance값 갱신 
			for (int j = 1; j < N+1; j++) { 
				if (!check[j] && arr[index][j] != -1 && distance[index] + arr[index][j] < distance[j]) { // 간선이 연결되지 않은 -1의 경우 역시 제외해야함 
					distance[j] = distance[index] + arr[index][j];
				}
			}
		}

		System.out.println(distance[end]); // 도착점까지의 최단 거리 출력 
		sc.close();
	}

}


/*
 * public class b02072022 {

	static int[][] maps;
	static boolean[] visited;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int edges = Integer.parseInt(st.nextToken());

		maps = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		dp = new int[n + 1];

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				maps[i][j] = -1;
			}
		}

		Arrays.fill(dp, 100000 * (n-1) + 1);

		for (int i = 0; i < edges; i++) {

			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (maps[r][c] == -1) {
				maps[r][c] = w;
			} else {
				maps[r][c] = Math.min(w, maps[r][c]);
			}
		}

		

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);

		dp[start] = 0;

		while (!queue.isEmpty()) {

			int current = queue.poll();

			if (!visited[current]) {

				visited[current] = true;

				PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						if (maps[current][o1] < maps[current][o2] ) {
							return -1;
						} else if (maps[current][o1] > maps[current][o2]) {
							return 1;
						} else {
							return 0;
						}
					}
				});

				for (int i = 1; i < visited.length; i++) {

					if (maps[current][i] != -1) {

						dp[i] = Math.min(dp[i], dp[current] + maps[current][i]);

						if (!visited[i]) {
							priorityQueue.add(i);
						}

					}
				}

				System.out.println(priorityQueue.peek());
				queue.add(priorityQueue.poll());

			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]);
		}

		//System.out.println(dp[end]);
		
	}
}
 */