package backjoon;

//import java.io.*;
import java.util.*;

//Fly me to the Alpha Centauri
//17042022

public class b17042022 {

      public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
 
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
        
			int X = in.nextInt();
			int Y = in.nextInt();
			
			int distance = Y - X;	
			
			int max = (int)Math.sqrt(distance);
            
			if(max == Math.sqrt(distance)) {
				System.out.println(max * 2 - 1);
			}
			else if(distance <= max * max + max) {
				System.out.println(max * 2);
			}
			else {
				System.out.println(max * 2 + 1);
			}
			
		}

            in.close();
	}
}