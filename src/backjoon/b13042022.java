package backjoon;

import java.util.*;

//피보나치 함수
//13042022

public class b13042022 {

      static int find_0;
      static int find_1;

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int count = sc.nextInt();

            while (count > 0) {

                  int num = sc.nextInt();
                  find_0 = 0;
                  find_1 = 0;

                  recusrion(num);

                  System.out.println(find_0 + " " + find_1);

                  count--;
            }

            sc.close();
      }

      public static void recusrion(int num) {
            if (num == 0 || num == 1) {

                  if (num == 0) {
                        find_0++;
                  } else if (num == 1) {
                        find_1++;
                  }

                  return;
            }

            recusrion(num - 1);
            recusrion(num - 2);
      }

} // 맞긴 맞는데, dp로 풀어야 함

/*
import java.util.Scanner;
 
public class Main {
 
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		int T = in.nextInt();
        
		while(T-- > 0){
			int N = in.nextInt();
			fibonacci(N);
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
		
	}
	
	static Integer[] fibonacci(int N) {
		// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if(dp[N][0] == null || dp[N][1] == null) {
			// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
 
	}
 
}

*/
