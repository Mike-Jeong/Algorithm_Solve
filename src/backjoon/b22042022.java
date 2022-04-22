package backjoon;

import java.io.*;
import java.util.*;

//보물
//22042022

public class b22042022 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        PriorityQueue<Integer> a = new PriorityQueue<>();
		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
 
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }

		int total = 0;
		for (int i = 0; i < n; i++) {
			total += (a.poll() * b.poll());
		}

		System.out.println(total);

		sc.close();
		
	}

}