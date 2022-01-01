package backjoon;

import java.util.Scanner;

//01012021
public class b10869 {
    public static void main(String[] args) throws Exception {
        
		Scanner in = new Scanner(System.in);
		
		int a=in.nextInt();
		int b=in.nextInt();
		
		in.close();
		System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }
}
