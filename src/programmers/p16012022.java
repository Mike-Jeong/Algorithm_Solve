package programmers;

//약수의 개수와 덧셈
//16012022

public class p16012022 {
    public static void main(String[] args) throws Exception {
        Solution18 s = new Solution18();

        int a = 13;
        int b = 17;

        System.out.println(s.solution(a,b));
        
    }
}

class Solution18 {

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            
            int count_divisor = 0;
            for (int j = 1; j < i; j++) {
                if (i%j == 0) {
                    count_divisor++;
                }
            }

            if (count_divisor % 2 == 0) {
                answer -= i;
                
            } else {
                answer += i;
            }
        }
        return answer;
    }
}