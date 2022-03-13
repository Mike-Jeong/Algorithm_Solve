package programmers;

import java.util.*;

//[3차] 방금그곡
//13032022

public class p13032022_02 {
    public static void main(String[] args) throws Exception {

        Solution77 s = new Solution77();

        String a = "ABCDEFG";
        String[] b = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };

        System.out.println(s.solution(a, b));

    }
}

class Solution77 {

    public String solution(String m, String[] musicinfos) {

        m = m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");

        int length = 0;
        String answer = "(None)";

        for (String strings : musicinfos) {
            String[] info = strings.split(",");

            info[3] = info[3].replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");

            int song_length = (Integer.parseInt(info[1].substring(3, 5)) - Integer.parseInt(info[0].substring(3, 5))) + (60 * (Integer.parseInt(info[1].substring(0, 2)) - Integer.parseInt(info[0].substring(0, 2))));

            int multi_s = song_length / info[3].length();
            int rest_s = song_length % info[3].length();

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < multi_s; j++) {
                sb.append(info[3]);
            }

            String string = sb.append(info[3].substring(0, rest_s)).toString();

            if (string.contains(m)) {
                if (string.length() > length) {
                    answer = info[2];
                    length = string.length();
                }
            }       
        }

        return answer;
    }
}