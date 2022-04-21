package backjoon;

import java.io.*;
import java.util.*;

//약수
//21042022

public class b21042022 {



	public static void main(String[] args) throws NumberFormatException, IOException {

		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while(T-- > 0) {
			int N = in.nextInt();
			max = N > max ? N : max;
			min = N < min ? N : min;
            
		}
		System.out.println(max * min);

		in.close();
	}

}