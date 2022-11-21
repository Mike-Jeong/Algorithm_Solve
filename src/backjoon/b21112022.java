package backjoon;

import java.io.*;
import java.util.*;

//민식어
//21112022

public class b21112022 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		String[] strings = new String[n];

		for (int i = 0; i < n; i++) {
			strings[i] = br.readLine();
			strings[i] = strings[i].replaceAll("k", "c").replaceAll("ng", "n~");
		}

		Arrays.sort(strings);


		for (int i = 0; i < n; i++) {
			System.out.println(strings[i].replaceAll("c", "k").replaceAll("n~", "ng"));
		}
	}
}