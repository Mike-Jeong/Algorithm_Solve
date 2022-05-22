package backjoon;

import java.io.*;
import java.util.*;

//제곱수의 합
//22052022

public class b22052022 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int d[]= new int[N+1];

        //d[n] = min(d[n - i^2] + 1)
        for (int i = 1; i <= N; i++){
            d[i] = i;
            for (int j = 1; j*j <= i; j++){
                if (d[i] > d[i-j*j]+1){
                    d[i] = d[i-j*j]+1;
                }
            }
        }
		
        System.out.println(d[N]);

		sc.close();
    }
}