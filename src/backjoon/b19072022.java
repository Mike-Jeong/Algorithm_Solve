package backjoon;

//import java.io.*;
import java.util.*;

//베르트랑 공준
//19072022

public class b19072022 {

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();

			if (n == 0) {
				sc.close();
				break;
			}

			int lastNum = n * 2 + 1;
			boolean[] primeCk = new boolean[lastNum];

			for (int i = 2; i <= Math.sqrt(lastNum); i++) {
				for (int j = i + i; j < lastNum; j += i) {
					primeCk[j] = true;
				}
			}

			int count = 0;

			for (int i = n + 1; i < primeCk.length; i++) {
				if (!primeCk[i]) {
					count++;
				}
			}

			System.out.println(count);
		}

	}

}