package backjoon;

import java.util.Scanner;

//01012021
public class b2588 {
    public static void main(String[] args) throws Exception {
        
		Scanner in = new Scanner(System.in);
		
		int a=in.nextInt();
		int b=in.nextInt();
		
		in.close();
		System.out.println(a*(b%10));
        System.out.println(a*(b%100/10));
        System.out.println(a*(b/100));
        System.out.println(a*b);
    }
}
