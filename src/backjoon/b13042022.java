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

}
