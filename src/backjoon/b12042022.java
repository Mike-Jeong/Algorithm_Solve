package backjoon;

import java.util.*;

//터렛
//12042022

public class b12042022 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        while (count > 0) {

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            find_coordinateNum(x1, y1, x2, y2, r1, r2);

            count--;
        }

        sc.close();
    }

    public static void find_coordinateNum(int x1, int y1, int x2, int y2, int r1, int r2) {

        int distance_2 = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
 
		if(x1 == x2 && y1 == y2 && r1 == r2) {
            System.out.println(-1);
		}

		else if(distance_2 > Math.pow(r1 + r2, 2)) {
            System.out.println(0);
		}
 
		else if(distance_2 < Math.pow(r2 - r1, 2)) {
            System.out.println(0);
		}
		
		else if(distance_2 == Math.pow(r2 - r1, 2)) {
            System.out.println(1);
		}
        
		else if(distance_2 == Math.pow(r1 + r2, 2)) {
            System.out.println(1);
		}
		
		else {
            System.out.println(2);
		}
    }
}
