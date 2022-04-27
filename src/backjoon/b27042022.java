package backjoon;

import java.io.*;
import java.util.*;

//트리 순회
//27042022

public class b27042022 {
	public static void main(String[] args) throws IOException {

		Tree tr = new Tree();

		for (int i = 0; i < 7; i++) {
			char alphabet = (char) ((int) 'A' + i);
			tr.addNode(alphabet);
		}

		tr.putNodeLeft('A', 'B');
		tr.putNodeRight('A', 'C');
		tr.putNodeLeft('B', 'D');
		tr.putNodeLeft('C', 'E');
		tr.putNodeRight('C', 'F');
		tr.putNodeRight('F', 'G');

		tr.preorder('A');
		System.out.println("Pre------------------------------------------");
		tr.inorder('A');
		System.out.println("In------------------------------------------");
		tr.postorder('A');
		System.out.println("Post------------------------------------------");
		

	}
}

class Tree {

	Map<Character, Node> nodes = new HashMap<>();

	public boolean addNode(char a) {

		if (!nodes.containsKey(a)) {
			Node node = new Node(a);
			nodes.put(a, node);
			return true;
		}

		return false;
	}

	public boolean putNodeLeft(char a, char b) {

		if (nodes.containsKey(a)) {
			if (nodes.containsKey(b)) {
				nodes.get(a).left = nodes.get(b);
			}
		}

		return false;
	}

	public boolean putNodeRight(char a, char b) {

		if (nodes.containsKey(a)) {
			if (nodes.containsKey(b)) {
				nodes.get(a).right = nodes.get(b);
			}
		}

		return false;
	}

	public void preorder(char node) {
		Node cur = nodes.get(node);
		System.out.println(cur.getCurrent());
		if (cur.left != null) {
			preorder(cur.left.getCurrent());
		}
		if (cur.right != null) {
			preorder(cur.right.getCurrent());
		}
	}

	public void inorder(char node) {
		Node cur = nodes.get(node);
		if (cur.left != null) {
			inorder(cur.left.getCurrent());
		}
		System.out.println(cur.getCurrent());
		if (cur.right != null) {
			inorder(cur.right.getCurrent());
		}
	}

	public void postorder(char node) {
		Node cur = nodes.get(node);
		if (cur.left != null) {
			postorder(cur.left.getCurrent());
		}
		if (cur.right != null) {
			postorder(cur.right.getCurrent());
		}
		System.out.println(cur.getCurrent());
	}

	class Node {

		private char current;

		Node left;
		Node right;

		public Node(char a) {
			current = a;
			left = null;
			right = null;
		}

		public char getCurrent() {
			return current;
		}
	}
}