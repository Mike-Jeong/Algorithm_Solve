package backjoon;

import java.io.*;
import java.util.*;

//사다리
//22082022

public class b22082022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		double num1 = Double.parseDouble(st.nextToken());
		double num2 = Double.parseDouble(st.nextToken());
		double num3 = Double.parseDouble(st.nextToken());

		double left = 0, right = Math.min(num1, num2);

        while (right - left >= 0.001) {
            double width = (left + right) / 2;
            double h1 = Math.sqrt(Math.pow(num1, 2) - Math.pow(width, 2));
            double h2 = Math.sqrt(Math.pow(num2, 2) - Math.pow(width, 2));
            double res = (h1 * h2) / (h1 + h2);
  
            if (res >= num3) left = width;
            else right = width;
        }
        System.out.println(String.format("%.3f", right));

    }
}