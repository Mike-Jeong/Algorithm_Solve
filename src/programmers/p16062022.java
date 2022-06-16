package programmers;

import java.util.*;

//?
//16062022

public class p16062022 {

    public static void main(String[] args) throws Exception {

        Solution112 s = new Solution112();

        int a = 4;
        int[][] b = { { 0, 1 }, {1,3}};
        int[][] c = { { 0, 2 }};

        System.out.println(s.solution(a,b,c));

    }
}

class Solution112 {

    Map<Integer, Node> nodeMap = new HashMap<>();
    Queue<Integer> leaf = new LinkedList<>();
    ArrayList<Integer> ans = new ArrayList<>();


    public int[] solution(int N, int[][] left, int[][] right) {

        for (int i = 0; i < N; i++) {
            nodeMap.put(i, new Node());
            nodeMap.get(i).value = i;
        }

        for (int i = 0; i < right.length; i++) {
            nodeMap.get(right[i][0]).setRight(nodeMap.get(right[i][1]));
            nodeMap.get(right[i][1]).parent = nodeMap.get(right[i][0]);
        }

        for (int i = 0; i < left.length; i++) {
            nodeMap.get(left[i][0]).setLeft(nodeMap.get(left[i][1]));
            nodeMap.get(left[i][1]).parent = nodeMap.get(left[i][0]);
        }

        dfs(nodeMap.get(0));

        reversebfs(nodeMap.get(0));

        int[] answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    
        return answer;
    }

    public void dfs(Node node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leaf.add(node.value);
        }

        if (node.right != null) {
            dfs(node.right);
        }

        if (node.left != null) {
            dfs(node.left);
        }

    }

    public void reversebfs(Node node) {

        if (node == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();

        while (!leaf.isEmpty()) {
            int n = leaf.poll();
            queue.offer(nodeMap.get(n));
            
        }

        while (!queue.isEmpty()) {

            Node n = queue.poll();

            ans.add(n.value);

            if (n != null) {

                if (n.parent != null) {

                    if (n.parent.left != null) {
                        if (n.parent.left.equals(n)) {
                            n.parent.left = null;
                        } 
                    }

                    if (n.parent.right != null) {
                        if (n.parent.right.equals(n)) {
                            n.parent.right = null;
                        }
                    }
                    
                    if (n.parent.left == null && n.parent.right ==null && !queue.contains(n.parent)) {
                        queue.offer(n.parent);
                    }
                }
            }
        }

    }
}

class Node {

    int value;

    Node parent;

    Node left;
    Node right;

    public void setLeft(Node node) {

        left = node;

    }

    public void setRight(Node node) {
        right = node;
    }

}