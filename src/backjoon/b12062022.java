package backjoon;

import java.io.*;
//import java.util.*;

//돌게임
//12062022

public class b12062022 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		bw.write((N % 2 == 1) ? "SK" : "CY");
		bw.flush();
		bw.close();
		br.close();

  }
}
