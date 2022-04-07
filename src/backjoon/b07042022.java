package backjoon;

import java.io.*;
import java.util.*;

//암호 만들기
//07042022

public class b07042022 {

    static int[] alphabet;
    static int n_Password;

      public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n_Password = Integer.parseInt(str[0]);
        int n_Alphabet = Integer.parseInt(str[1]);

        alphabet = new int[n_Alphabet];

        str = br.readLine().split(" ");

        for (int i = 0; i < n_Alphabet; i++) {
            alphabet[i] = str[i].charAt(0);
        }
        
        Arrays.sort(alphabet);

        

    }

    public static void bfs_a() {

        
    }

   
}

