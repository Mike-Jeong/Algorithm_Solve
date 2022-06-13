package backjoon;

import java.io.*;
import java.util.*;

//BABBA
//13062022

public class b13062022 {

  public static void main(String[] args) throws IOException {

	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();

	int[] dpA = new int[n + 1];
	int[] dpB = new int[n + 1];

	dpA[0] = 1;
	dpB[1] = 1;

	for (int i = 2; i < dpB.length; i++) {

		dpA[i] = dpB[i - 1];
		dpB[i] = dpB[i - 1] + dpB[i-2];

	}

	System.out.println(dpA[n] + " " + dpB[n]);

	sc.close();

  }
}
