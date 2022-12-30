package backjoon;

import java.io.*;
import java.util.*;

//양팔저울
//30122022

public class b30122022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numMarble = Integer.parseInt(st.nextToken());

		boolean[] checkWeights = new boolean[40001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numMarble; i++) {

			int weight = Integer.parseInt(st.nextToken());

			boolean[] tempCheckWeights = new boolean[40001];
			for (int j = 0; j < 40001; j++) {
				if (checkWeights[j]) {
					tempCheckWeights[j] = true;
					tempCheckWeights[Math.abs(weight - j)] = true;
					tempCheckWeights[weight + j] = true;
				}
			}
			tempCheckWeights[weight] = true;

			checkWeights = tempCheckWeights;
		}

		st = new StringTokenizer(br.readLine());
		int numWeight = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numWeight; i++) {

			int marble = Integer.parseInt(st.nextToken());

			System.out.print(checkWeights[marble] ? "Y" : "N");
			System.out.print(" ");

		}
	}

}