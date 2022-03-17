package programmers;

import java.util.*;

//방문 길이
//17032022

public class p17032022 {

    public static void main(String[] args) throws Exception {

        Solution82 s = new Solution82();

        String a = "ULURRDLLU";

        System.out.println(s.solution(a));

    }
}

class Solution82 {

    public int solution(String dirs) {

        Set<String> visited = new LinkedHashSet<>();
        int answer = 0;

        int x = 0;
        int y = 0;

        int x_max = 5;
        int y_max = 5;
        int x_min = -5;
        int y_min = -5;

        visited.add("00");
        for (int i = 0; i < dirs.length(); i++) {

            char dir = dirs.charAt(i);

            if (dir == 'U') {

                if (y + 1 >= y_min && y + 1 <= y_max) {
                    String before = String.valueOf(x) + String.valueOf(y);
                    y += 1;
                    String current_p = String.valueOf(x) + String.valueOf(y);
                    if (!visited.contains(current_p + before) && !visited.contains(before + current_p)) {
                        visited.add(before + current_p);
                        answer++;
                    }
                }

            } else if (dir == 'D') {
                if (y - 1 >= y_min && y - 1 <= y_max) {
                    String before = String.valueOf(x) + String.valueOf(y);
                    y -= 1;
                    String current_p = String.valueOf(x) + String.valueOf(y);
                    if (!visited.contains(current_p + before) && !visited.contains(before + current_p)) {
                        visited.add(before + current_p);
                        answer++;
                    }
                }
            } else if (dir == 'L') {
                if (x - 1 >= x_min && x - 1 <= x_max) {
                    String before = String.valueOf(x) + String.valueOf(y);
                    x -= 1;
                    String current_p = String.valueOf(x) + String.valueOf(y);
                    if (!visited.contains(current_p + before) && !visited.contains(before + current_p)) {
                        visited.add(before + current_p);
                        answer++;
                    }
                }
            } else {
                if (x + 1 >= x_min && x + 1 <= x_max) {
                    String before = String.valueOf(x) + String.valueOf(y);
                    x += 1;
                    String current_p = String.valueOf(x) + String.valueOf(y);
                    if (!visited.contains(current_p + before) && !visited.contains(before + current_p)) {
                        visited.add(before + current_p);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}