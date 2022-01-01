package backjoon;

import java.util.Scanner;

//01012021
public class b10430 {
    public static void main(String[] args) throws Exception {
        
		Scanner in = new Scanner(System.in);
		
		int a=in.nextInt();
		int b=in.nextInt();
        int c=in.nextInt();
		
		in.close();
		System.out.println((a+b) % c);
        System.out.println(((a%c) + (b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c) * (b%c))%c);
    }
}
