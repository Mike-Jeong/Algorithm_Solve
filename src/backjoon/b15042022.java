package backjoon;

import java.io.*;
import java.util.*;

//ACM Craft
//15042022

public class b15042022 {

      static Map<Integer, ArrayList<Integer>> nodes = new HashMap<>();
      static int[] times;
<<<<<<< HEAD
=======
      static ArrayList<Integer>[] no;
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
      static int ans = 0;

      public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int test_n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < test_n; i++) {

                  st = new StringTokenizer(br.readLine());

                  int num_node = Integer.parseInt(st.nextToken());
<<<<<<< HEAD
=======
                  no = new ArrayList[num_node + 1];
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
                  times = new int[num_node + 1];

                  int rules = Integer.parseInt(st.nextToken());

                  st = new StringTokenizer(br.readLine());

                  for (int j = 1; j <= num_node; j++) {
<<<<<<< HEAD
=======
                        no[j] = new ArrayList<>();
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
                        times[j] = Integer.parseInt(st.nextToken());
                  }

                  for (int j = 0; j < rules; j++) {
                        st = new StringTokenizer(br.readLine());

                        int first_node = Integer.parseInt(st.nextToken());
                        int second_node = Integer.parseInt(st.nextToken());

<<<<<<< HEAD
                        if (!nodes.containsKey(second_node)) {
                              nodes.put(second_node, new ArrayList<>());
                        }

                        nodes.get(second_node).add(first_node);
=======
                        no[second_node].add(first_node);
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62

                  }

                  st = new StringTokenizer(br.readLine());

                  int target = Integer.parseInt(st.nextToken());

                  recusrion(target, 0);

                  System.out.println(ans);

            }

      }

      public static void recusrion(int num, int count) {

<<<<<<< HEAD
            ArrayList<Integer> current_node = nodes.get(num);
            count += times[num];

            if (current_node == null) {
=======
            count += times[num];

            if (no[num].size() == 0) {
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62

                  if (count > ans) {
                        ans = Math.max(ans, count);
                  }

                  return;
            }

<<<<<<< HEAD
            for (int i = 0; i < current_node.size(); i++) {
                  recusrion(current_node.get(i), count);
            }
      }

}// 첫번째 답
=======
            for (int i = 0; i < no[num].size(); i++) {

                  recusrion(no[num].get(i), count);
            }
      }

}

>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62

// 답은 다 맞지만, 시간 초과
// 위상정렬 공부할것

/*
import java.io.*;
import java.util.*;

<<<<<<< HEAD
//ACM Craft
//15042022

public class b15042022 {

      static int[] times;
      static ArrayList<Integer>[] no;
=======

public class Main {

      static Map<Integer, ArrayList<Integer>> nodes = new HashMap<>();
      static int[] times;
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
      static int ans = 0;

      public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int test_n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < test_n; i++) {

                  st = new StringTokenizer(br.readLine());

                  int num_node = Integer.parseInt(st.nextToken());
<<<<<<< HEAD
                  no = new ArrayList[num_node + 1];
=======
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
                  times = new int[num_node + 1];

                  int rules = Integer.parseInt(st.nextToken());

                  st = new StringTokenizer(br.readLine());

                  for (int j = 1; j <= num_node; j++) {
<<<<<<< HEAD
                        no[j] = new ArrayList<>();
=======
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
                        times[j] = Integer.parseInt(st.nextToken());
                  }

                  for (int j = 0; j < rules; j++) {
                        st = new StringTokenizer(br.readLine());

                        int first_node = Integer.parseInt(st.nextToken());
                        int second_node = Integer.parseInt(st.nextToken());

<<<<<<< HEAD
                        no[second_node].add(first_node);
=======
                        if (!nodes.containsKey(second_node)) {
                              nodes.put(second_node, new ArrayList<>());
                        }

                        nodes.get(second_node).add(first_node);
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62

                  }

                  st = new StringTokenizer(br.readLine());

                  int target = Integer.parseInt(st.nextToken());

                  recusrion(target, 0);

                  System.out.println(ans);

            }

      }

      public static void recusrion(int num, int count) {

<<<<<<< HEAD
            count += times[num];

            if (no[num].size() == 0) {
=======
            ArrayList<Integer> current_node = nodes.get(num);
            count += times[num];

            if (current_node == null) {
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62

                  if (count > ans) {
                        ans = Math.max(ans, count);
                  }

                  return;
            }

<<<<<<< HEAD
            for (int i = 0; i < no[num].size(); i++) {

                  recusrion(no[num].get(i), count);
            }
      }
}
*/ //내가 두번째 쓴 답

// 백준 답
/*
import java.util.*;
 
public class Main {    
 
    static int n, w;
    static ArrayList<Integer>[] list; //연결 간선 정보
    static int[] building; //빌딩 짓는 비용 정보
    static int[] indegree;
    static int[] buildCost; //각 위치까지 빌딩을 짓는 비용의 최대값을 저장한다.
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            n = scan.nextInt();
            int k = scan.nextInt();
            
            building = new int[n + 1];
            list = new ArrayList[n + 1];
            for(int j = 1; j <= n; j++) {
                building[j] = scan.nextInt();
                list[j] = new ArrayList<>();
            }
            
            indegree = new int[n + 1];
            for(int j = 0; j < k; j++) {
                int s = scan.nextInt();
                int e = scan.nextInt();
                list[s].add(e); 
                indegree[e]++;
            }
            w = scan.nextInt(); //건설해야 할 건물의 번호
            
            buildCost = new int[n + 1]; 
            topologySort();
            System.out.println(buildCost[w]);
        }
    }
    
    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                buildCost[i] = building[i];
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                buildCost[next] = Math.max(buildCost[current] + building[next], buildCost[next]);
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
    }
}

*/
=======
            for (int i = 0; i < current_node.size(); i++) {
                  recusrion(current_node.get(i), count);
            }
      }

}

*/ //내가 쓴 답
>>>>>>> b5313a0fc214d9d5b7d621da531a6caedca51a62
