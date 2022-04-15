package backjoon;

import java.io.*;
import java.util.*;

//ACM Craft
//15042022

public class b15042022 {

      static Map<Integer, ArrayList<Integer>> nodes = new HashMap<>();
      static int[] times;
      static int ans = 0;

      public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int test_n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < test_n; i++) {

                  st = new StringTokenizer(br.readLine());

                  int num_node = Integer.parseInt(st.nextToken());
                  times = new int[num_node + 1];

                  int rules = Integer.parseInt(st.nextToken());

                  st = new StringTokenizer(br.readLine());

                  for (int j = 1; j <= num_node; j++) {
                        times[j] = Integer.parseInt(st.nextToken());
                  }

                  for (int j = 0; j < rules; j++) {
                        st = new StringTokenizer(br.readLine());

                        int first_node = Integer.parseInt(st.nextToken());
                        int second_node = Integer.parseInt(st.nextToken());

                        if (!nodes.containsKey(second_node)) {
                              nodes.put(second_node, new ArrayList<>());
                        }

                        nodes.get(second_node).add(first_node);

                  }

                  st = new StringTokenizer(br.readLine());

                  int target = Integer.parseInt(st.nextToken());

                  recusrion(target, 0);

                  System.out.println(ans);

            }

      }

      public static void recusrion(int num, int count) {

            ArrayList<Integer> current_node = nodes.get(num);
            count += times[num];

            if (current_node == null) {

                  if (count > ans) {
                        ans = Math.max(ans, count);
                  }

                  return;
            }

            for (int i = 0; i < current_node.size(); i++) {
                  recusrion(current_node.get(i), count);
            }
      }

}// 첫번째 답

// 답은 다 맞지만, 시간 초과
// 위상정렬 공부할것

/*
import java.io.*;
import java.util.*;

//ACM Craft
//15042022

public class b15042022 {

      static int[] times;
      static ArrayList<Integer>[] no;
      static int ans = 0;

      public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int test_n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < test_n; i++) {

                  st = new StringTokenizer(br.readLine());

                  int num_node = Integer.parseInt(st.nextToken());
                  no = new ArrayList[num_node + 1];
                  times = new int[num_node + 1];

                  int rules = Integer.parseInt(st.nextToken());

                  st = new StringTokenizer(br.readLine());

                  for (int j = 1; j <= num_node; j++) {
                        no[j] = new ArrayList<>();
                        times[j] = Integer.parseInt(st.nextToken());
                  }

                  for (int j = 0; j < rules; j++) {
                        st = new StringTokenizer(br.readLine());

                        int first_node = Integer.parseInt(st.nextToken());
                        int second_node = Integer.parseInt(st.nextToken());

                        no[second_node].add(first_node);

                  }

                  st = new StringTokenizer(br.readLine());

                  int target = Integer.parseInt(st.nextToken());

                  recusrion(target, 0);

                  System.out.println(ans);

            }

      }

      public static void recusrion(int num, int count) {

            count += times[num];

            if (no[num].size() == 0) {

                  if (count > ans) {
                        ans = Math.max(ans, count);
                  }

                  return;
            }

            for (int i = 0; i < no[num].size(); i++) {

                  recusrion(no[num].get(i), count);
            }
      }
}
*/ //내가 두번째 쓴 답
