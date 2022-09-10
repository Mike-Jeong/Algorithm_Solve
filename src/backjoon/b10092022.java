package backjoon;

import java.io.*;
import java.util.*;

//달팽이는 올라가고 싶다
//10092022

public class b10092022 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
 
		int ans = (l - d) / (u - d);
		if ((l - d) % (u - d) != 0)
			ans++;
 
		System.out.println(ans);
	}
}
