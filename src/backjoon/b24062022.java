package backjoon;

import java.io.*;
import java.util.*;

//
//24062022

public class b24062022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] soldiers =new int[N];
        int[] dp = new int[N+1];

        Arrays.fill(dp,1);
        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int k = 0;
        while (st.hasMoreTokens()){
            soldiers[k++]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(soldiers[i]<soldiers[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        Arrays.sort(dp);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(N-dp[N]));
        bw.flush();
        bw.close();

    }

}