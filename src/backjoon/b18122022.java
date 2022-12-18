package backjoon;

import java.io.*;
import java.util.*;

//나이순 정렬
//18122022

public class b18122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Queue<User> users = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String string = st.nextToken();

			users.add(new User(i, age, string));
		}

		while (!users.isEmpty()) {
			System.out.println(users.poll());
		}

	}
}

class User implements Comparable<User> {

	private int index;
	private int age;
	private String name;

	public User(int index, int age, String name) {
		this.index = index;
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(User o) {

		if (age == o.age) {
			return index - o.index;
		}

		return age - o.age;
	}

	@Override
	public String toString() {
		return age + " " + name;
	}
}