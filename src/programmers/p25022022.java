package programmers;

//조이스틱
//25022022

public class p25022022 {
    public static void main(String[] args) throws Exception {

        Solution58 s = new Solution58();

        String a = "ABAAB";

        System.out.println(s.solution(a));
    }
}

class Solution58 {

    public int solution(String name) {

        int answer = 0;
        int move = name.length() - 1;
        int index;

        for (int i = 0; i < name.length(); i++) {

            int alpha = Math.abs('A' - name.charAt(i));
            int s = Math.min(alpha, 26 - alpha);
            answer += s;

            index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, i * 2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
        }

        answer = answer + move;

        return answer;
    }
}