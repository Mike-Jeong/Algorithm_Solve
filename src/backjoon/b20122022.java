package backjoon;

//import java.io.*;
import java.util.*;

//개수 세기
//20122022

public class b20122022 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}

		int v = sc.nextInt();

		for (int i = 0; i < array.length; i++) {
			if (v == array[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);

		sc.close();

	}

}