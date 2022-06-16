package backjoon;

import java.io.*;
import java.util.*;

//타일 장식물
//16062022

public class b16062022 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		ArrayList<Long> result = new ArrayList<>();
		ArrayList<Long> fibo = new ArrayList<>();
		fibo.add((long) 1);
		fibo.add((long) 1);
		for(int i=2; i<num; i++) {
			fibo.add(fibo.get(i-2)+fibo.get(i-1));
		}
		result.add((long) 4);
		for(int i=1; i<num;i++) {
			result.add(result.get(i-1)+2*fibo.get(i));
		}
		bw.write(String.valueOf(result.get(num-1)));
		
	
		bw.flush();
		bw.close();

	}
}