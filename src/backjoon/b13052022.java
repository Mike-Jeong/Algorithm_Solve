package backjoon;

import java.io.*;
import java.util.*;

//스택 수열
//13052022

public class b13052022 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 0;
		
		while(N -- > 0) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {

				for(int i = start + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');	
				}
				start = value; 	
			}
			
			else if(stack.peek() != value) {
				System.out.println("NO");
				return;		
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
	}
}