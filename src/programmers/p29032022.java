package programmers;

//import java.util.*;

//양궁대회
//29032022

public class p29032022 {

    public static void main(String[] args) throws Exception {

        Solution93 s = new Solution93();

        int a = 5;
        int[] b = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };

        System.out.println(s.solution(a, b));

    }
}

class Solution93 {

    int[] info;
    int[] temp = { -1 };
    int num;
    int minus = 0;

    public int[] solution(int n, int[] info) {

        this.info = info;
        num = n;

        int sum = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0) {
                sum += (10 - i);
            }
        }

        recursion(0, 0, 0, new int[11], sum);

        int[] answer = temp;
        return answer;
    }

    public void recursion(int count, int t_sum, int index, int[] pos, int sum) {

        if (count >= num || index == 11) {
            if (count <= num) {
                if (t_sum > sum) {
                    if ((t_sum - sum) >= minus) {
                        if (index == 11 && count < num) {
                            pos[10] += (num - count);
                        }
                        
                        temp = pos.clone();
                        minus = (t_sum - sum);

                        if (index == 11 && count < num) {
                            pos[10] -= (num - count);
                        }
                    }
                }
            }
            
            return;
        }

        pos[index] += (info[index] + 1);

        if (info[index] != 0) {
            sum -= (10 - index);
        }

        recursion(count + (info[index] + 1), t_sum + ((10 - index)), index + 1, pos, sum);

        if (info[index] != 0) {
            sum += (10 - index);
        }

        pos[index] -= (info[index] + 1);
        recursion(count, t_sum, index + 1, pos, sum);
    }
}

/*
static int[] res = { -1 };
    static int[] lion;
    static int max = -1000;
    public void dfs(int[] info, int cnt, int n) {
        if(cnt == n+1) {
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++) 
            {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i]) 
                        lion_point += 10 - i;
                    else 
                        apeach_point += 10 - i;
                }
            }
            if(lion_point > apeach_point) {
                if(lion_point - apeach_point >= max)
                {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            return ;
        }
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        }
    }
    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info,1,n);
        return res;
    }
}
//퍼온거... 다시풀어야될듯
*/