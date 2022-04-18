package backjoon;

//import java.io.*;
import java.util.*;

//감소하는 수
//18042022

public class b18042022 {

	static ArrayList<Long> list;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        list = new ArrayList<>();
        
        if(n <= 10) System.out.println(n);
        else if(n > 1022) System.out.println("-1");
        else {
            for(int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            Collections.sort(list);
 
            System.out.println(list.get(n));
        }

		sc.close();
    }    
    
    public static void bp(long num, int idx) {
        if(idx > 10) return;
        
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }
}
