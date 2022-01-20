package programmers;

import java.util.*;

//문자열 압축
//19012022

public class p19012022 {
    public static void main(String[] args) throws Exception {
        Solution22 s = new Solution22();

        String a = "xxxxxxxxxxyyy";

        System.out.println(s.solution(a));

    }
}

class Solution22 {

    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < (s.length() / 2) + 1; i++) {
            String pre = "";
            int count = 1;
            StringBuilder newString = new StringBuilder("");

            int j = 0;
            for (; j + i <= s.length(); j += i) {
                String current = s.substring(j, j + i);

                if (current.equals(pre)) {

                    if (count != 1) {
                        count++;
                        int index = 1;
                        if (!(count<=10)) {
                            index = Integer.toString(count).length();
                        } 
                        newString.replace(newString.lastIndexOf(pre) - index, newString.lastIndexOf(pre) + i,
                                Integer.toString(count) + pre);
                    }

                    else {
                        count++;
                        newString.replace(newString.lastIndexOf(pre), newString.lastIndexOf(pre) + i,
                                Integer.toString(count) + pre);
                    }
                } else {
                    newString.append(current);
                    pre = current;
                    count = 1;
                }

            }

            answer = Math.min(answer, newString.length() + s.length() - j);

        }

        return answer;
    }
}//20012022 최종 답안

/*
 * public int solution(String s) {
 * int answer = s.length();
 * 
 * for (int i = 1; i < s.length() / 2 + 1; i++) {
 * String prev = s.substring(0, i);
 * int count = 1;
 * String enc = "";
 * String last = "";
 * for (int j = i; j < s.length(); j += i) {
 * if (j + i > s.length()) {
 * last = s.substring(j);
 * continue;
 * }
 * if (prev.equals(s.substring(j, j + i))) {
 * count++;
 * } else {
 * enc += prev;
 * if (count != 1) {
 * enc = count + enc;
 * }
 * prev = s.substring(j, j + i);
 * count = 1;
 * }
 * }
 * enc += prev + last;
 * if (count != 1) {
 * enc = count + enc;
 * }
 * 
 * answer = Math.min(answer, enc.length());
 * }
 * 
 * return answer;
 * }
 * }
 */
//정답 배껴옴(구글)


/*public int solution(String s) {

    int answer = s.length();

    for (int i = 1; i < (s.length() / 2) + 1; i++) {
        StringBuilder newString = new StringBuilder("");

        String pre = "";
        int count = 1;

        int j = 0;

        while (true) {
            if (!(j + i <= s.length())) {

                newString.append(pre);
                if (count != 1) {
                    newString.append(count);
                }

                break;
            }
            if (j != 0) {
                if (s.substring(j, j + i).equals(pre)) {
                    count++;
                } else {
                    if (count != 1) {
                        newString.append(count);
                    }

                    newString.append(pre);

                    pre = s.substring(j, j + i);
                    count = 1;
                }
            } else {
                pre = s.substring(j, j + i);
            }

            j += i;
        }

        System.out.println(newString);

        if (newString.toString().matches(".*[0-9].*")) {
            answer = Math.min(answer, newString.length());
        }

    }

    return answer;
}*/
//19012022 혼자 생각한 결과물(실패)