package backjoon;

import java.io.*;
import java.util.*;

//최대공약수
//03122022

public class b03122022 {

	static char[][] map;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = '*';
			}
		}

		recursion(0, 0, n);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}
	}

	static void recursion(int row, int col, int range) {

		/*for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}

		System.out.println("---------------------------------------");*/

		

		if (range == 1) {
			return;
		}

		int count = 0;
		for (int i = 0; i < map.length; i+=(range / 3)) {
			for (int j = 0; j < map.length; j+=(range/3)) {

				if (count == 4) {
					
					for (int j2 = 0; j2 < range/3; j2++) {
						for (int k = 0; k < range/3; k++) {
							System.out.println((j2 + i) + " " + (k + j) + " " + range/3);
							map[j2 + i][k + j] = ' ';
						}
					}
					
				} else {
					recursion(i, j, range / 3);
				}

				count++;
			}
		}
	}
}



/* 

***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************

*/